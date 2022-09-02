package ru.geekbrains.handler;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

class PutMethodHandler extends MethodHandlerImpl {

    public PutMethodHandler(MethodHandlerImpl next, SocketService socketService, ServerConfig config) {
        super("PUT", next, socketService, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .withProtocol("HTTP/1.1")
                .withStatusCode(200)
                .withStatusCodeName("OK")
                .addHeader("Content-Type", "text/html; charset=utf-8")
                .withBody("<h1>PUT method handler</h1>")
                .build();
    }
}
