package by.epam.task.service;

import by.epam.task.bean.Book;

import java.util.List;

public interface CatalogService {

    List<Book> getCatalog() throws ServiceException;

    void addBook(Book book) throws ServiceException;

    boolean removeBook(String title) throws ServiceException;
}
