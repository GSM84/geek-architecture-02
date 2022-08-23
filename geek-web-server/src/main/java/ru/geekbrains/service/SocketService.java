package ru.geekbrains.service;

import java.io.IOException;
import java.util.Deque;

public interface SocketService {

    Deque<String> readRequest();

    void writeResposnse(String rawResponse);

    public void close() throws IOException;
}
