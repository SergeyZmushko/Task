package by.epam.task.dao;

import by.epam.task.bean.User;

import java.util.List;

public interface UserDAO {

    boolean authorization(String login, String password) throws DAOException;

    boolean registration(User user) throws DAOException;

    User searchUser(String login, String password) throws DAOException;

    List<User> getUsers() throws DAOException;

}
