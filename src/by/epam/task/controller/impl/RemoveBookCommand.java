package by.epam.task.controller.impl;

import by.epam.task.controller.Command;
import by.epam.task.presentation.CatalogActionView;
import by.epam.task.presentation.impl.CatalogActionViewImpl;
import by.epam.task.service.CatalogService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.ServiceProvider;


public class RemoveBookCommand implements Command {
    @Override
    public String execute(String[] params) {
        ServiceProvider provider = ServiceProvider.getInstance();
        CatalogService catalogService = provider.getCatalogService();

        String title;
        title = params[1].split("=")[1];
        boolean result;
        try {
            result = catalogService.removeBook(title);
            CatalogActionView catalogActionView = new CatalogActionViewImpl();
            return catalogActionView.removeBook(result);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
