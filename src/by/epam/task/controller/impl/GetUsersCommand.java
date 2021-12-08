package by.epam.task.controller.impl;

import by.epam.task.bean.User;
import by.epam.task.controller.Command;
import by.epam.task.presentation.UserActionViewer;
import by.epam.task.presentation.impl.UserActionViewImpl;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;
import by.epam.task.service.UserService;

import java.util.List;

public class GetUsersCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        try {
            List<User> users = userService.getUsers();
            UserActionViewer userActionViewer = new UserActionViewImpl();
            return userActionViewer.getUsers(users);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
