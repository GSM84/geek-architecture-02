package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.FileServiceFactory;
import ru.geekbrains.service.SocketService;
import ru.geekbrains.service.SocketServiceFactory;
import java.io.IOException;
import java.net.Socket;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final FileService fileService;
    private final SocketService socketService;

    public RequestHandler(Socket socket, String dir) {
        this.fileService   = FileServiceFactory.create(dir);
        this.socketService = SocketServiceFactory.create(socket);
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = RequestParser.parse(rawRequest);
        HttpResponse httpResponse = null;

        if (!fileService.exists(httpRequest.getPath())) {
            httpResponse = HttpResponse.createBuilder()
                    .withProtocol("HTTP/1.1")
                    .withStatusCode(404)
                    .addHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>Файл не найден!</h1>")
                    .build();

        } else if (fileService.isDirectory(httpRequest.getPath())) {
            httpResponse = HttpResponse.createBuilder()
                            .withProtocol("HTTP/1.1")
                            .withStatusCode(404)
                            .addHeader("Content-Type", "text/html; charset=utf-8")
                            .withBody("<h1>Передана директория вместо файла!</h1>")
                            .build();
        }

        if (httpResponse != null) {
            socketService.writeResposnse(ResponseSerializer.serialize(httpResponse));
            try {
                socketService.close();
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
            return;
        }

        httpResponse = HttpResponse.createBuilder()
                        .withProtocol("HTTP/1.1")
                        .withStatusCode(200)
                        .addHeader("Content-Type", "text/html; charset=utf-8")
                        .withBody(fileService.readFile(httpRequest.getPath()))
                        .build();

        socketService.writeResposnse(ResponseSerializer.serialize(httpResponse));
        System.out.println("Client disconnected!");

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

    }
}

