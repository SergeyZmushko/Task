package by.epam.task.presentation.impl;

import by.epam.task.bean.Book;
import by.epam.task.presentation.BookActionView;

import java.util.List;

public class BookActionViewImpl implements BookActionView {
    @Override
    public String searchedBookByTitleAnswer(Book book) {
        String response;
        if (book != null) {
            response = "0 книга найдена";
        } else {
            response = "1 такой книги нет";
        }
        return response;
    }

    @Override
    public String searchBookByAuthorAnswer(List<Book> books) {
        String response;
        if (!books.isEmpty()) {
            response = "0 книга найдена";
        } else {
            response = "1 такой книги нет";
        }
        return response;
    }

    @Override
    public String addDiscribeBook(String result) {
        String response;
        if (result != null) {
            response = "0 описание добавлено";
        } else {
            response = "1 описание не добавлено";
        }
        return response;
    }
}
