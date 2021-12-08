package by.epam.task.service.impl;

import by.epam.task.bean.Letter;
import by.epam.task.dao.DAOException;
import by.epam.task.dao.DAOProvider;
import by.epam.task.dao.LetterDAO;
import by.epam.task.service.LetterService;
import by.epam.task.service.ServiceException;

import java.util.List;

public class LetterServiceImpl implements LetterService {
    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public List<Letter> getLetters(String email) throws ServiceException {
        LetterDAO letterDAO = provider.getLetterDAO();
        List<Letter> letterList;
        try {
            letterList = letterDAO.getLetters(email);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return letterList;
    }

    public void suggestAddBook(Letter letter) throws ServiceException {
        LetterDAO letterDAO = provider.getLetterDAO();
        try {
            letterDAO.suggestAddBook(letter);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public String showMessage(Letter letter) throws ServiceException {
        LetterDAO letterDAO = provider.getLetterDAO();
        String message;
        try {
            message = letterDAO.showMessage(letter);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return message;
    }

    @Override
    public boolean notification(String email, String bookTitle) throws ServiceException {
        boolean result;
        LetterDAO letterDAO = provider.getLetterDAO();
        try {
            result = letterDAO.notification(email, bookTitle);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
