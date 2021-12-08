package by.epam.task.controller.impl;

import by.epam.task.bean.Letter;
import by.epam.task.controller.Command;
import by.epam.task.presentation.LetterActionView;
import by.epam.task.presentation.impl.LetterActionViewImpl;
import by.epam.task.service.LetterService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

public class SuggestAddBookCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        LetterService letterService = serviceProvider.getLetterService();
        String recipientEmail = params[1].split("=")[1];
        String title = params[2].split("=")[1];
        String message = params[3].split("=")[1];
        String senderEmail = params[4].split("=")[1];

        Letter letter = new Letter.Builder()
                .withRecipientEmail(recipientEmail)
                .withTitle(title)
                .withMessage(message)
                .withSenderEmail(senderEmail)
                .withLetterType(Letter.LetterType.UNREAD.getValue())
                .build();
        try {
            letterService.suggestAddBook(letter);
            LetterActionView letterActionView = new LetterActionViewImpl();
            return letterActionView.suggestAddBook(letter);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }

    }
}
