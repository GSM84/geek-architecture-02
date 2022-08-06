package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements Runnable {

    private final Socket socket;
    private final FileApi fileApi;
    private  final HttpApi httpApi;

    public RequestHandler(Socket socket, FileApi fileApi, HttpApi httpApi) {
        this.socket = socket;
        this.fileApi = fileApi;
        this.httpApi = httpApi;
    }

    @Override
    public void run() {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        ) {
            while (!input.ready());

            httpApi.fetchFileName(input);

            fileApi.formatPath(httpApi.getFileName());

            if (fileApi.isFileExists(output)) {
                fileApi.pushFile(output);
            }

            System.out.println("Client disconnected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

