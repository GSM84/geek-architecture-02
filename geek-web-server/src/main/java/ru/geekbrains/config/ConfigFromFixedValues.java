package ru.geekbrains.config;

class ConfigFromFixedValues implements ServerConfig {

    @Override
    public String getWww() {
        return "D:\\Study\\Java\\architecture\\www";
    }

    @Override
    public int getPort() {
        return 8088;
    }
}
