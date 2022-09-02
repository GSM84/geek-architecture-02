package ru.geekbrains.handler;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

class GetMethodHandler extends MethodHandlerImpl {

    private final FileService fileService;

    public GetMethodHandler(MethodHandlerImpl next, SocketService socketService, ServerConfig config, FileService fileService) {
        super("GET", next, socketService, config);
        this.fileService = fileService;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        if (!fileService.exists(request.getPath())) {
            return HttpResponse.createBuilder()
                    .withProtocol("HTTP/1.1")
                    .withStatusCode(404)
                    .addHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>Файл не найден!</h1>")
                    .build();

        } else if (fileService.isDirectory(request.getPath())) {
            return HttpResponse.createBuilder()
                    .withProtocol("HTTP/1.1")
                    .withStatusCode(404)
                    .addHeader("Content-Type", "text/html; charset=utf-8")
                    .withBody("<h1>Передана директория вместо файла!</h1>")
                    .build();
        }

        return HttpResponse.createBuilder()
                .withProtocol("HTTP/1.1")
                .withStatusCode(200)
                .addHeader("Content-Type", "text/html; charset=utf-8")
                .withBody(fileService.readFile(request.getPath()))
                .build();
    }
}
