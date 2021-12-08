package by.epam.task.controller.impl;

import by.epam.task.bean.Letter;
import by.epam.task.controller.Command;
import by.epam.task.presentation.LetterActionView;
import by.epam.task.presentation.impl.LetterActionViewImpl;
import by.epam.task.service.LetterService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

public class ShowMessageCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        LetterService letterService = serviceProvider.getLetterService();

        String recepientEmail = params[1].split("=")[1];
        String titleMessage = params[2].split("=")[1];
        String message = params[3].split("=")[1];
        String senderMessage = params[4].split("=")[1];
        String type = params[5].split("=")[1];

        Letter letter = new Letter.Builder()
                .withRecipientEmail(recepientEmail)
                .withTitle(titleMessage)
                .withMessage(message)
                .withSenderEmail(senderMessage)
                .withLetterType(type)
                .build();

        try {
            letterService.showMessage(letter);
            LetterActionView letterActionView = new LetterActionViewImpl();
            return letterActionView.showMessage(letter);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
