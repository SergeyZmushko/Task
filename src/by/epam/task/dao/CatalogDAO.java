package by.epam.task.dao;

import by.epam.task.bean.Book;

import java.util.List;


public interface CatalogDAO {

    List<Book> getCatalog() throws DAOException;

    void addBook(Book book) throws DAOException;

    boolean removeBook(String title) throws DAOException;

}
