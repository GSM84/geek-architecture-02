package ru.geekbrains.patterns.bahavior.mediator;

import java.util.Calendar;

public class ChatRoom implements ChatRoomMediator {
    @Override
    public void showMessage(User user, String message) {
        System.out.println(String.format("%s [%s]: %s", Calendar.getInstance().getTime(), user.getName(), message));
    }
}
