package by.epam.task.dao;

import by.epam.task.bean.Book;

import java.util.List;

public interface BookDAO {

    Book searchBookByTitle(String title) throws DAOException;

    List<Book> searchBookByAuthor(String author) throws DAOException;

    String addDiscribe(String TitleOfDescribingBook, String describe) throws DAOException;
}
