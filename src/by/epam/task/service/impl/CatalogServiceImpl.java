package by.epam.task.service.impl;

import by.epam.task.bean.Book;
import by.epam.task.dao.CatalogDAO;
import by.epam.task.dao.DAOException;
import by.epam.task.dao.DAOProvider;
import by.epam.task.service.CatalogService;
import by.epam.task.service.ServiceException;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public List<Book> getCatalog() throws ServiceException {
        List<Book> books;

        CatalogDAO catalogDAO = provider.getCatalogDAO();
        try {
            books = catalogDAO.getCatalog();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return books;
    }

    @Override
    public void addBook(Book book) throws ServiceException {
        CatalogDAO catalogDAO = provider.getCatalogDAO();
        try {
            catalogDAO.addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean removeBook(String title) throws ServiceException {
        CatalogDAO catalogDAO = provider.getCatalogDAO();
        try {
            return catalogDAO.removeBook(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
