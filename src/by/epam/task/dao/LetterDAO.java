package by.epam.task.dao;

import by.epam.task.bean.Letter;


import java.util.List;

public interface LetterDAO {
    List<Letter> getLetters(String email) throws DAOException;

    void suggestAddBook(Letter letter) throws DAOException;

    String showMessage(Letter letter) throws DAOException;

    boolean notification(String email, String bookTitle) throws DAOException;
}
