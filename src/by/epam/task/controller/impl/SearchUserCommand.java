package by.epam.task.controller.impl;

import by.epam.task.bean.User;
import by.epam.task.controller.Command;
import by.epam.task.presentation.UserActionViewer;
import by.epam.task.presentation.impl.UserActionViewImpl;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;
import by.epam.task.service.UserService;

public class SearchUserCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String login = params[1].split("=")[1];
        String password = params[2].split("=")[1];
        User user;
        try {
            user = userService.searchUser(login, password);
            UserActionViewer userActionViewer = new UserActionViewImpl();
            return userActionViewer.serchUserAnswer(user);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
