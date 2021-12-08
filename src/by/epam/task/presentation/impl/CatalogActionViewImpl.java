package by.epam.task.presentation.impl;

import by.epam.task.bean.Book;
import by.epam.task.presentation.CatalogActionView;

import java.util.List;

public class CatalogActionViewImpl implements CatalogActionView {
    @Override
    public String getCatalogAnswer(List<Book> bookList) {
        String response;
        if (!bookList.isEmpty()) {
            response = "0 Каталог успешно загружен.";
        } else {
            response = "1 Ошибка получения каталога.";
        }
        return response;
    }

    @Override
    public String addBookAnswer(Book book) {
        String response;
        if (book != null) {
            response = "0 Книга успешно добавлена.";
        } else {
            response = "1 Ошибка, книга не добавлена.";
        }
        return response;
    }

    public String removeBook(boolean result) {
        String response;
        if (result) {
            response = "0 Книга успешно удалена.";
        } else {
            response = "1 Ошибка, книга не удалена.";
        }
        return response;
    }
}
