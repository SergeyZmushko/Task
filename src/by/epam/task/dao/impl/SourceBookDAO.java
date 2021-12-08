package by.epam.task.dao.impl;

import by.epam.task.bean.Book;
import by.epam.task.dao.BookDAO;
import by.epam.task.dao.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SourceBookDAO implements BookDAO {
    @Override
    public Book searchBookByTitle(String title) throws DAOException {
        Book book = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Catalog.txt")))) {
            String s = "";
            while ((s = reader.readLine()) != null) {
                String[] s1 = s.split(" : ");
                if (s1[0].equalsIgnoreCase(title)) {
                    book = new Book.Builder().withTitle(s1[0]).withAuthor(s1[1]).withDescription(s1[2]).withBookType(s1[3]).build();
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> searchBookByAuthor(String author) throws DAOException {
        List<Book> searchedBooks = null;
        Book book;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Catalog.txt")))) {
            String s = "";
            searchedBooks = new ArrayList<>();
            while ((s = reader.readLine()) != null) {
                String[] s1 = s.split(" : ");
                if (s1[1].equalsIgnoreCase(author)) {
                    book = new Book.Builder().withTitle(s1[0]).withAuthor(s1[1]).withDescription(s1[2]).withBookType(s1[3]).build();
                    searchedBooks.add(book);
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchedBooks;
    }


    @Override
    public String addDiscribe(String titleOfDescribingBook, String describe) throws DAOException {
        String bookTitle = null;
        File sourceFile = new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Catalog.txt");
        File outputFile = new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Catalog1.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            if (outputFile.exists()) {
                outputFile.createNewFile();
            }
            String s = "";
            while ((s = reader.readLine()) != null) {
                String[] s1 = s.split(" : ");
                if (s1[0].equalsIgnoreCase(titleOfDescribingBook)) {
                    for (int i = 0; i < s1.length; i++) {
                        if (i < s1.length - 1 && i != 2) {
                            writer.write(s1[i] + " : ");
                        } else if (i < s1.length - 1 && i == 2) {
                            String newLine = s1[2] + " " + describe;
                            writer.write(newLine + " : ");
                            bookTitle = titleOfDescribingBook;
                        } else {
                            writer.write(s1[i]);
                        }
                    }
                    writer.newLine();
                } else {
                    for (int i = 0; i < s1.length; i++) {
                        if (i < s1.length - 1) {
                            writer.write(s1[i] + " : ");
                        } else {
                            writer.write(s1[i]);
                        }
                    }
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
            sourceFile.delete();
            outputFile.renameTo(sourceFile);
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookTitle;
    }
}
