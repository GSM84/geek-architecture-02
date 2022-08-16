package ru.geekbrains;

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
        String firstLine = rawRequest.pollFirst();
        String[] parts = firstLine.split(" ");

        if (!fileService.exists(parts[1]) || fileService.isDirectory(parts[1])) {
            System.out.println("HERE");
            String rawResponse = "HTTP/1.1 404 NOT_FOUND\n"+
                                 "Content-Type: text/html; charset=utf-8\n"+
                                 "\n"+
                                 "<h1>Файл не найден!</h1>";

            socketService.writeResposnse(rawResponse);
            try {
                socketService.close();
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
            return;
        }

        String rawResponse =
                "HTTP/1.1 200 OK\n"+
                "Content-Type: text/html; charset=utf-8\n"+
                "\n"+
                fileService.readFile(parts[1]);


        socketService.writeResposnse(rawResponse);
        System.out.println("Client disconnected!");


        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }

    }
}

