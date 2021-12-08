package by.epam.task.menu.action;

import by.epam.task.bean.Book;
import by.epam.task.controller.LibraryController;
import by.epam.task.menu.input.InputData;
import by.epam.task.service.CatalogService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.impl.CatalogServiceImpl;

import java.util.List;

public class CatalogAction {
    public static List<Book> processGetCatalog() {
        System.out.println("Просмотр каталога.");
        LibraryController controller = new LibraryController();
        List<Book> books = null;

        String request;

        request = "getCatalog^ ";

        String response;

        response = controller.doAction(request);
        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            CatalogService catalogService = new CatalogServiceImpl();
            try {
                books = catalogService.getCatalog();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Каталог не загружен.");
        }
        return books;
    }

    public static void processAddBook() {
        System.out.println("Добавление новой книги.");
        LibraryController controller = new LibraryController();

        String title = InputData.enterFromConsoleString("Введите название книги >>");
        String author = InputData.enterFromConsoleString("Введите автора книги >>");
        String description = InputData.enterFromConsoleString("Введите описание книги >>");
        String bookType = null;
        System.out.println("1. Электронная. \n" +
                "2. Бумажная.");
        int type = InputData.enterFromConsoleInt("Выберите тип книги >>");
        if (type == 1) {
            bookType = Book.BookType.EBOOK.getValue();
        } else if (type == 2) {
            bookType = Book.BookType.PAPERBOOK.getValue();
        }

        String request;
        request = "addBook^title=" + title + "^author=" + author + "^description=" + description + "^bookType=" + bookType;

        String response;
        response = controller.doAction(request);

        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            System.out.println("Книга успешно добавлена в каталог.");
        } else {
            System.out.println("Ошибка.");
        }
    }

    public static void processRemoveBook() {
        System.out.println("Удаление книги.");
        LibraryController controller = new LibraryController();

        String title = InputData.enterFromConsoleString("Введите название книги >>");

        String request;
        request = "removeBook^title=" + title;

        String response;
        response = controller.doAction(request);

        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            System.out.println("Книга успешно удалена.");
        } else {
            System.out.println("Ошибка.");
        }
    }
}
