package by.epam.task.dao;

import by.epam.task.dao.impl.SourceBookDAO;
import by.epam.task.dao.impl.SourceCatalogDAO;
import by.epam.task.dao.impl.SourceLettersDAO;
import by.epam.task.dao.impl.SourceUserDAO;

public final class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private UserDAO userDAO = new SourceUserDAO();
    private CatalogDAO catalogDAO = new SourceCatalogDAO();
    private BookDAO bookDAO = new SourceBookDAO();
    private LetterDAO letterDAO = new SourceLettersDAO();

    private DAOProvider() {}

    public static DAOProvider getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public CatalogDAO getCatalogDAO() {
        return catalogDAO;
    }

    public void setCatalogDAO(CatalogDAO catalogDAO) {
        this.catalogDAO = catalogDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public LetterDAO getLetterDAO() {
        return letterDAO;
    }

    public void setLetterDAO(LetterDAO letterDAO) {
        this.letterDAO = letterDAO;
    }
}
