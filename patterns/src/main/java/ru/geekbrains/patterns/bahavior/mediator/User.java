package ru.geekbrains.patterns.bahavior.mediator;

public class User {
    private String name;
    private ChatRoomMediator mediator;

    public User(String name, ChatRoomMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        this.mediator.showMessage(this, message);
    }
}
