package ru.geekbrains.service;

public interface FileService {

    public boolean exists(String fileName);

    public boolean isDirectory(String fileName);

    public String readFile(String fileName);
}
