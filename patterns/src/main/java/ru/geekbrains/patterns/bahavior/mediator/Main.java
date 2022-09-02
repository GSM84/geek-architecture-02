package ru.geekbrains.patterns.bahavior.mediator;

public class Main {
    public static void main(String[] args) {
        ChatRoomMediator mediator = new ChatRoom();
        User u1 = new User("Ivan", mediator);
        User u2 = new User("Andrey", mediator);

        u1.send("Hi there");
        u1.send("Hola!");
    }
}
