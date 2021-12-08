package by.epam.task.controller.impl;

import by.epam.task.controller.Command;
import by.epam.task.presentation.LetterActionView;
import by.epam.task.presentation.impl.LetterActionViewImpl;
import by.epam.task.service.LetterService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

public class NotificationCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        LetterService letterService = serviceProvider.getLetterService();

        String email = params[1].split("=")[1];
        String bookTitle = params[2].split("=")[1];
        boolean result = false;
        try {
            result = letterService.notification(email, bookTitle);
            LetterActionView letterActionView = new LetterActionViewImpl();
            return letterActionView.notification(result);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
