package by.epam.task.controller.impl;

import by.epam.task.controller.Command;
import by.epam.task.presentation.UserActionViewer;
import by.epam.task.presentation.impl.UserActionViewImpl;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;
import by.epam.task.service.UserService;

public class LoginationCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String login = params[1].split("=")[1];
        String password = params[2].split("=")[1];

        boolean result;
        try {
            result = userService.logination(login, password);
            UserActionViewer userActionViewer = new UserActionViewImpl();
            return userActionViewer.loginationAnswer(result);
        } catch (ServiceException e) {
            return "Error";
        }
    }
}
