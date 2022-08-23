package ru.geekbrains.service;

public class FileServiceFactory {

    public static FileServiceImpl create(String dir) {
        return new FileServiceImpl(dir);
    }
}
