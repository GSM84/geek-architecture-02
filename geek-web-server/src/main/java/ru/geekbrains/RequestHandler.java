package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final FileService fileService;
    private final SocketService socketService;

    public RequestHandler(SocketService socketService, FileService fileService) {
        this.fileService = fileService;
        this.socketService = socketService;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = RequestParser.parse(rawRequest);
        HttpResponse httpResponse = new HttpResponse();

        if (!fileService.exists(httpRequest.getPath())) {
            httpResponse.setProtocol("HTTP/1.1");
            httpResponse.setStatusCode(404);
            httpResponse.addHeader("Content-Type", "text/html; charset=utf-8");
            httpResponse.setBody("<h1>Файл не найден!</h1>");

        } else if (fileService.isDirectory(httpRequest.getPath())) {
            httpResponse.setProtocol("HTTP/1.1");
            httpResponse.setStatusCode(404);
            httpResponse.addHeader("Content-Type", "text/html; charset=utf-8");
            httpResponse.setBody("<h1>Передана директория вместо файла!</h1>");

        }

        if (httpResponse.getStatusCode() > 0) {
            socketService.writeResposnse(ResponseSerializer.serialize(httpResponse));
            try {
                socketService.close();
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
            return;
        }

        httpResponse.setProtocol("HTTP/1.1");
        httpResponse.setStatusCode(200);
        httpResponse.addHeader("Content-Type", "text/html; charset=utf-8");
        httpResponse.setBody(fileService.readFile(httpRequest.getPath()));

        socketService.writeResposnse(ResponseSerializer.serialize(httpResponse));
        System.out.println("Client disconnected!");


        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

    }
}

