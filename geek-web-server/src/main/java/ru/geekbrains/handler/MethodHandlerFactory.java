package ru.geekbrains.handler;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

public final class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ServerConfig config, FileService fileService) {
        PutMethodHandler putHandler = new PutMethodHandler(null ,socketService, config);
        PostMethodHandler postHandler = new PostMethodHandler(putHandler, socketService, config);
        return new GetMethodHandler(postHandler, socketService, config, fileService);
    }
}
