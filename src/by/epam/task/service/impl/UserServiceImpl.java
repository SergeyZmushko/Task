package by.epam.task.service.impl;

import by.epam.task.bean.User;
import by.epam.task.dao.DAOException;
import by.epam.task.dao.DAOProvider;
import by.epam.task.dao.UserDAO;
import by.epam.task.service.ServiceException;
import by.epam.task.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public boolean logination(String login, String password) throws ServiceException {
        //validation
        UserDAO userDAO = provider.getUserDAO();
        boolean result;
        try {
            result = userDAO.authorization(login, password);
            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean registrating(User user) throws ServiceException {
        //validation
        UserDAO userDAO = provider.getUserDAO();
        boolean result;
        try {
            result = userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public User searchUser(String login, String password) throws ServiceException {
        User user;
        UserDAO userDAO = provider.getUserDAO();
        try {
            user = userDAO.searchUser(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public List<User> getUsers() throws ServiceException {
        List<User> users;
        UserDAO userDAO = provider.getUserDAO();
        try {
            users = userDAO.getUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return users;
    }
}
