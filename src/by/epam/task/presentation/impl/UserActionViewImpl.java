package by.epam.task.presentation.impl;

import by.epam.task.bean.User;
import by.epam.task.presentation.UserActionViewer;

import java.util.List;


public class UserActionViewImpl implements UserActionViewer {
    @Override
    public String loginationAnswer(boolean result) {
        String response;
        if (result) {
            response = "0 User hello";
        } else {
            response = "1 error";
        }
        return response;
    }

    @Override
    public String registrationAnswer(boolean result) {
        String response;
        if (result) {
            response = "0 registration successful";
        } else {
            response = "1 registration Error";
        }
        return response;
    }

    @Override
    public String serchUserAnswer(User user) {
        String response;
        response = user.getLogin() + " : " + user.getUsername() + " : " + user.getPassword() + " : " + user.getEmail() + " : " + user.getUserType();
        return response;
    }

    public String getUsers(List<User> users) {
        String response;
        if (users.isEmpty()) {
            response = "1 error getList";
        } else {
            response = "0 users list";
        }
        return response;
    }
}
