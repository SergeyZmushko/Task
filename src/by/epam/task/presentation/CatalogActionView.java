package by.epam.task.presentation;

import by.epam.task.bean.Book;

import java.util.List;

public interface CatalogActionView {
    String getCatalogAnswer(List<Book> bookList);

    String addBookAnswer(Book book);

    String removeBook(boolean result);

}
