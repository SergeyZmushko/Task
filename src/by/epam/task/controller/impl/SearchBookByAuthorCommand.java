package by.epam.task.controller.impl;

import by.epam.task.bean.Book;
import by.epam.task.controller.Command;
import by.epam.task.presentation.BookActionView;
import by.epam.task.presentation.impl.BookActionViewImpl;
import by.epam.task.service.BookService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

import java.util.List;

public class SearchBookByAuthorCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();

        String author;
        author = params[1].split("=")[1];
        List<Book> books;
        try {
            books = bookService.searchBookByAuthor(author);
            BookActionView bookActionView = new BookActionViewImpl();
            return bookActionView.searchBookByAuthorAnswer(books);

        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }

    }
}

