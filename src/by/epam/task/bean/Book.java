package by.epam.task.bean;

public class Book {
    private String title;
    private String author;
    private String description;
    private BookType bookType;

    public Book() {
    }

    public Book(String title, String author, String description, BookType bookType) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.bookType = bookType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public BookType getBookType() {
        return bookType;
    }

    public static class Builder {
        private Book newBook;

        public Builder() {
            newBook = new Book();
        }

        public Builder withTitle(String title) {
            newBook.title = title;
            return this;
        }

        public Builder withAuthor(String author) {
            newBook.author = author;
            return this;
        }

        public Builder withDescription(String description) {
            newBook.description = description;
            return this;
        }

        public Builder withBookType(String bookType) {
            if (bookType.equalsIgnoreCase("Электронная книга")) {
                newBook.bookType = BookType.EBOOK;
            } else if (bookType.equalsIgnoreCase("Бумажная книга")) {
                newBook.bookType = BookType.PAPERBOOK;
            }
            return this;
        }


        public Book build() {
            return newBook;
        }

    }

    public static enum BookType {
        EBOOK("Электронная книга"),
        PAPERBOOK("Бумажная книга");

        private String value;

        BookType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        return bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (bookType != null ? bookType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Название: " + title + "\n" +
                "Автор: " + author + "\n" +
                "Описание: " + description + "\n" +
                "Тип книги: " + bookType.getValue();
    }
}
