package by.epam.task.service;

import by.epam.task.bean.Letter;


import java.util.List;

public interface LetterService {
    List<Letter> getLetters(String email) throws ServiceException;

    void suggestAddBook(Letter letter) throws ServiceException;

    String showMessage(Letter letter) throws ServiceException;

    boolean notification(String email, String bookTitle) throws ServiceException;
}
