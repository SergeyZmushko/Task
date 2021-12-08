package by.epam.task.controller.impl;

import by.epam.task.bean.Book;
import by.epam.task.controller.Command;
import by.epam.task.presentation.CatalogActionView;
import by.epam.task.presentation.impl.CatalogActionViewImpl;
import by.epam.task.service.CatalogService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;

import java.util.List;

public class GetCatalogCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        CatalogService catalogService = provider.getCatalogService();

        try {
            List<Book> bookList = catalogService.getCatalog();
            CatalogActionView catalogActionView = new CatalogActionViewImpl();
            return catalogActionView.getCatalogAnswer(bookList);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }

    }
}
