package by.epam.task.controller.impl;

import by.epam.task.bean.User;
import by.epam.task.controller.Command;
import by.epam.task.presentation.UserActionViewer;
import by.epam.task.presentation.impl.UserActionViewImpl;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;
import by.epam.task.service.UserService;

public class RegistrationCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        String registrationLogin = params[1].split("=")[1];
        String registrationNickname = params[2].split("=")[1];
        String registrationPassword = params[3].split("=")[1];
        String registrationEmail = params[4].split("=")[1];
        User user = new User.Builder()
                .withLogin(registrationLogin)
                .withUsername(registrationNickname)
                .withPassword(registrationPassword)
                .withEmail(registrationEmail)
                .withUserType(User.UserType.USER)
                .build();
        boolean result;

        try {
            result = userService.registrating(user);
            UserActionViewer userActionViewer = new UserActionViewImpl();
            return userActionViewer.registrationAnswer(result);
        } catch (ServiceException e) {
            return "Error";
        }
    }
}
