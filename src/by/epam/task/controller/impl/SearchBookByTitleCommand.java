package by.epam.task.controller.impl;

import by.epam.task.bean.Book;
import by.epam.task.controller.Command;
import by.epam.task.presentation.BookActionView;
import by.epam.task.presentation.impl.BookActionViewImpl;
import by.epam.task.service.BookService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

public class SearchBookByTitleCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();

        String title;
        title = params[1].split("=")[1];
        Book book;
        try {
            book = bookService.searchBookByTitle(title);
            BookActionView bookActionView = new BookActionViewImpl();
            return bookActionView.searchedBookByTitleAnswer(book);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }

    }
}
