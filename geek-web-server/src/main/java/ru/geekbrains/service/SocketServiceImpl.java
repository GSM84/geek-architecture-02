package ru.geekbrains.service;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;

class SocketServiceImpl implements SocketService {

    private final Socket socket;

    public SocketServiceImpl(Socket socket) {
        this.socket = socket;
    }

    public Deque<String> readRequest(){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

            while (!input.ready());

            Deque<String> response = new LinkedList<>();

            while (input.ready()) {
                String line = input.readLine();
                System.out.println(line);
                response.add(line);
            }

            return response;

        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public void writeResposnse(String rawResponse){
        try {
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            output.println(rawResponse);
            output.flush();

        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public void close() throws IOException {
        if (!socket.isClosed()) {
            socket.close();
        }
    }
}
