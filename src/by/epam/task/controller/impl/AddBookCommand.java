package by.epam.task.controller.impl;

import by.epam.task.bean.Book;
import by.epam.task.controller.Command;
import by.epam.task.presentation.CatalogActionView;
import by.epam.task.presentation.impl.CatalogActionViewImpl;
import by.epam.task.service.CatalogService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;


public class AddBookCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        CatalogService catalogService = serviceProvider.getCatalogService();

        String title = params[1].split("=")[1];
        String author = params[2].split("=")[1];
        String description = params[3].split("=")[1];
        String bookType = params[4].split("=")[1];

        Book book = new Book.Builder()
                .withTitle(title)
                .withAuthor(author)
                .withDescription(description)
                .withBookType(bookType)
                .build();
        try {
            catalogService.addBook(book);
            CatalogActionView catalogActionView = new CatalogActionViewImpl();
            return catalogActionView.addBookAnswer(book);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
