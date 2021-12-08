package by.epam.task.presentation;

import by.epam.task.bean.User;

import java.util.List;

public interface UserActionViewer {

    String loginationAnswer(boolean result);

    String registrationAnswer(boolean result);

    String serchUserAnswer(User user);

    String getUsers(List<User> users);
}
