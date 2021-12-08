package by.epam.task.menu.action;

import by.epam.task.bean.Book;
import by.epam.task.controller.LibraryController;
import by.epam.task.menu.input.InputData;
import by.epam.task.service.BookService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.impl.BookServiceImpl;

import java.util.List;

public class BookAction {
    public static String processAddDescription() {
        System.out.println("Добавление описания к книге.");
        LibraryController controller = new LibraryController();

        String title = InputData.enterFromConsoleString("Введите название книги >>");
        String description = InputData.enterFromConsoleString("Введите описание >>");

        String request;
        request = "addDiscribe^title=" + title + "^description=" + description;

        String response;
        response = controller.doAction(request);

        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            System.out.println("Описание успешно добавлено.");
        } else {
            System.out.println("Ошибка.");
        }
        return title;
    }

    public static Book processSearchBookByTitle() {
        System.out.println("Поиск книги по названию.");
        LibraryController controller = new LibraryController();
        Book book = null;

        String bookTitle;
        bookTitle = InputData.enterFromConsoleString("Введите название книги >>");
        System.out.println("Вы ищете: " + bookTitle);

        String request;
        request = "searchBookByTitle^bookTitle=" + bookTitle;

        String response;
        response = controller.doAction(request);

        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            BookService bookService = new BookServiceImpl();
            try {
                book = bookService.searchBookByTitle(bookTitle);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Книга с указанным названием не найдена.");
        }
        return book;
    }

    public static List<Book> processSearchBookByAuthor() {
        System.out.println("Поиск книг по автору.");
        LibraryController controller = new LibraryController();
        List<Book> books = null;

        String bookAuthor;
        bookAuthor = InputData.enterFromConsoleString("Введите имя автора >>");

        String request;

        request = "searchBookByAuthor^bookAuthor=" + bookAuthor;

        String response;
        response = controller.doAction(request);

        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            BookService bookService = new BookServiceImpl();
            try {
                books = bookService.searchBookByAuthor(bookAuthor);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Книги с указанным автором не найдены.");
        }
        return books;
    }
}
