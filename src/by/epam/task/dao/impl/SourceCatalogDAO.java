package by.epam.task.dao.impl;

import by.epam.task.bean.Book;
import by.epam.task.dao.CatalogDAO;
import by.epam.task.dao.DAOException;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SourceCatalogDAO implements CatalogDAO {
    @Override
    public List<Book> getCatalog() throws DAOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Catalog.txt")))) {
            String s = "";
            while ((s = reader.readLine()) != null) {
                String[] s1 = s.split(" : ");
                Book book = new Book.Builder().withTitle(s1[0]).withAuthor(s1[1]).withDescription(s1[2]).withBookType(s1[3]).build();
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void addBook(Book book) throws DAOException {
        try (FileWriter fw = new FileWriter("E://Epam/JavaOnlineTraining/Modul06/Task01/source/Catalog.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String bookData = "" + book.getTitle() + " : " + book.getAuthor() + " : " + book.getDescription() + " : " + book.getBookType().getValue();
            out.println();
            out.print(bookData);
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeBook(String title) throws DAOException {
        boolean result = false;
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
                if (s1[0].equalsIgnoreCase(title)) {
                    result = true;
                }
                if (!s1[0].equalsIgnoreCase(title)) {
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
        return result;
    }
}