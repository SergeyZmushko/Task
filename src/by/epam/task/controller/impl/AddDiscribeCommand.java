package by.epam.task.controller.impl;

import by.epam.task.controller.Command;
import by.epam.task.presentation.BookActionView;
import by.epam.task.presentation.impl.BookActionViewImpl;
import by.epam.task.service.BookService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

public class AddDiscribeCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();

        String title;
        String describeToAdd;

        title = params[1].split("=")[1];
        describeToAdd = params[2].split("=")[1];
        String result;

        try {
            result = bookService.addDiscribe(title, describeToAdd);
            BookActionView bookActionView = new BookActionViewImpl();
            return bookActionView.addDiscribeBook(result);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
