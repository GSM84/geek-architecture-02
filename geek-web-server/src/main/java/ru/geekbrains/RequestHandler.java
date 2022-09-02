package ru.geekbrains;

import ru.geekbrains.handler.MethodHandler;
import ru.geekbrains.service.SocketService;
import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final MethodHandler handler;

    public RequestHandler(SocketService socketService, MethodHandler handler) {
        this.socketService = socketService;
        this.handler = handler;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();

        handler.handle(RequestParser.parse(rawRequest));

        System.out.println("Client disconnected!");

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}

