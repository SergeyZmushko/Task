package by.epam.task.controller.impl;

import by.epam.task.bean.Letter;
import by.epam.task.controller.Command;
import by.epam.task.presentation.LetterActionView;
import by.epam.task.presentation.impl.LetterActionViewImpl;
import by.epam.task.service.LetterService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

import java.util.List;

public class GetLettersCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        LetterService letterService = provider.getLetterService();

        String login = params[1].split("=")[1];

        try {
            List<Letter> letterList = letterService.getLetters(login);
            LetterActionView letterActionView = new LetterActionViewImpl();
            return letterActionView.getLetters(letterList);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
