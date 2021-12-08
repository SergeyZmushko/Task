package by.epam.task.service;

import by.epam.task.bean.User;

import java.util.List;

public interface UserService {

    boolean logination(String login, String password) throws ServiceException;

    boolean registrating(User user) throws ServiceException;

    User searchUser(String login, String password) throws ServiceException;

    List<User> getUsers() throws ServiceException;
}


