package by.epam.task.service;

import by.epam.task.service.impl.BookServiceImpl;
import by.epam.task.service.impl.CatalogServiceImpl;
import by.epam.task.service.impl.LetterServiceImpl;
import by.epam.task.service.impl.UserServiceImpl;

public final class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private UserService userService = new UserServiceImpl();
    private CatalogService catalogService = new CatalogServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private LetterService letterService = new LetterServiceImpl();


    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public CatalogService getCatalogService() {
        return catalogService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public LetterService getLetterService() {
        return letterService;
    }
}
