package by.epam.task.service.impl;

import by.epam.task.bean.Book;
import by.epam.task.dao.BookDAO;
import by.epam.task.dao.DAOException;
import by.epam.task.dao.DAOProvider;
import by.epam.task.service.BookService;
import by.epam.task.service.ServiceException;


import java.util.List;

public class BookServiceImpl implements BookService {
    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public Book searchBookByTitle(String title) throws ServiceException {
        BookDAO bookDAO = provider.getBookDAO();
        try {
            return bookDAO.searchBookByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Book> searchBookByAuthor(String author) throws ServiceException {
        BookDAO bookDAO = provider.getBookDAO();
        try {
            return bookDAO.searchBookByAuthor(author);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public String addDiscribe(String TitleOfDescribingBook, String describe) throws ServiceException {
        BookDAO bookDAO = provider.getBookDAO();
        try {
            return bookDAO.addDiscribe(TitleOfDescribingBook, describe);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
