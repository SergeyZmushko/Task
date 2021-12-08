package by.epam.task.menu.action;

import by.epam.task.bean.User;
import by.epam.task.controller.LibraryController;
import by.epam.task.menu.input.InputData;
import by.epam.task.service.ServiceException;
import by.epam.task.service.UserService;
import by.epam.task.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UserAction {
    public static User processLogin() {
        System.out.println("Авторизация.");
        User user = null;
        String login = InputData.enterFromConsoleString("Введите логин >>");
        String password = InputData.enterFromConsoleString("Введите пароль >>");
        LibraryController controller = new LibraryController();

        String request;
        request = "logination^login=" + login + "^password=" + password;

        String response;

        response = controller.doAction(request);

        String result = response.split("\\s+")[0];

        if (result.equalsIgnoreCase("1")) {
            System.out.println("Ошибка");
        } else if (result.equalsIgnoreCase("0")) {
            UserService userService = new UserServiceImpl();
            try {
                user = userService.searchUser(login, password);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static void processRegistration() {
        LibraryController controller1 = new LibraryController();
        System.out.println("Регистрация:");
        String registrationLogin = InputData.enterFromConsoleString("Введите логин");
        String registrationNickname = InputData.enterFromConsoleString("Введите никнейм");
        String registrationPassword = InputData.enterFromConsoleString("Введите пароль");
        String registrationEmail = InputData.enterFromConsoleString("Введите почту");
        String request1;

        request1 = "registration^login=" + registrationLogin + "^nickname=" + registrationNickname + "^password=" + registrationPassword + "^email=" + registrationEmail;

        String response1;

        response1 = controller1.doAction(request1);

        String result1 = response1.split("\\s+")[0];
        if (result1.equalsIgnoreCase("0")) {
            System.out.println("Регистрация прошла успешно");
        } else {
            System.out.println("Ошибка регистрации");
        }
    }

    public static List<User> processGetUsers() {
        LibraryController controller = new LibraryController();
        List<User> users = new ArrayList<>();
        String request = "getUsers^";

        String response = controller.doAction(request);
        String result = response.split("\\s")[0];
        if (result.equalsIgnoreCase("0")) {
            UserService userService = new UserServiceImpl();
            try {
                users = userService.getUsers();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
