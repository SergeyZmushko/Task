package by.epam.task.service;

import by.epam.task.bean.Book;

import java.util.List;

public interface BookService {
    Book searchBookByTitle(String title) throws ServiceException;

    List<Book> searchBookByAuthor(String author) throws ServiceException;

    String addDiscribe(String TitleOfDescribingBook, String describe) throws ServiceException;

}
