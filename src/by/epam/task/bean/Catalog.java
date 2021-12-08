package by.epam.task.bean;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        return books != null ? books.equals(catalog.books) : catalog.books == null;
    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "books=" + books +
                '}';
    }
}
