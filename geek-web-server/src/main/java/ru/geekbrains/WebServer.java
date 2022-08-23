package ru.geekbrains;

import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.config.ServerConfigFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        ServerConfig config = ServerConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(
                        new RequestHandler(
                                socket
                              , config.getWww()
                        )
                ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
