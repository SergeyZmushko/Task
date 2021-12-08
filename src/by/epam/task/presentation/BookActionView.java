package by.epam.task.presentation;

import by.epam.task.bean.Book;

import java.util.List;

public interface BookActionView {
    String searchedBookByTitleAnswer(Book book);

    String searchBookByAuthorAnswer(List<Book> books);

    String addDiscribeBook(String result);
}
