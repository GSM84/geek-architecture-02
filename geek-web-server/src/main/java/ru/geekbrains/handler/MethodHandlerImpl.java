package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

abstract class MethodHandlerImpl implements MethodHandler{

    private final String method;

    private final MethodHandlerImpl next;

    protected final SocketService socketService;

    protected final ServerConfig config;

    public MethodHandlerImpl(String method, MethodHandlerImpl next, SocketService socketService, ServerConfig config) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.config = config;
    }

    @Override
    public void handle(HttpRequest request){
        HttpResponse response;
        if (method.equals(request.getMethod())){
            response = handleInternal(request);
        } else if (next != null) {
            next.handle(request);
            return;
        } else {
            response = HttpResponse.createBuilder()
                    .withProtocol("HTTP/1.1")
                    .withStatusCode(405)
                    .withStatusCodeName("METHOD_NOT_ALLOWED")
                    .addHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>Метод не поддерживается!</h1>")
                    .build();
        }
        socketService.writeResposnse(ResponseSerializer.serialize(response));
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
