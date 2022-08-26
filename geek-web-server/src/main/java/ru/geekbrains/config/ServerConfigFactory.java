package ru.geekbrains.config;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ServerConfigFactory {

    public static ServerConfig create(String[] args) {
        if (args.length >= 2) {
            System.out.println("command line");
            return new ConfigFromCli(args);
        } else if (Files.exists(Path.of("D:\\Study\\Java\\architecture\\geek-web-server\\src\\main\\resources\\server.properties"))) {
            System.out.println("file");
            return new ConfigFromFile("D:\\Study\\Java\\architecture\\geek-web-server\\src\\main\\resources\\server.properties");
        } else {
            System.out.println("fixed values");
            return new ConfigFromFixedValues();
        }
    }
}
