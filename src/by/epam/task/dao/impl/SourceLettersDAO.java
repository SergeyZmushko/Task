package by.epam.task.dao.impl;

import by.epam.task.bean.Letter;
import by.epam.task.dao.DAOException;
import by.epam.task.dao.LetterDAO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SourceLettersDAO implements LetterDAO {
    @Override
    public List<Letter> getLetters(String email) throws DAOException {
        List<Letter> letterList;
        File file = new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Mail.txt");
        letterList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s1 = line.split(" : ");
                if (s1[0].equalsIgnoreCase(email)) {
                    Letter letter = new Letter.Builder().withRecipientEmail(s1[0]).withTitle(s1[1]).withMessage(s1[2]).withSenderEmail(s1[3]).withLetterType(s1[4]).build();
                    letterList.add(letter);
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return letterList;
    }

    public void suggestAddBook(Letter letter) throws DAOException {
        try (FileWriter fw = new FileWriter("E://Epam/JavaOnlineTraining/Modul06/Task01/source/Mail.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String letterData = "" + letter.getRecipientEmail() + " : " + letter.getTitle() + " : " + letter.getMessage() + " : " + letter.getSenderEmail() + " : " + letter.getLetterType().getValue();
            out.println();
            out.print(letterData);
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String showMessage(Letter letter) throws DAOException {
        File sourceFile = new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Mail.txt");
        File outputFile = new File("E://Epam/JavaOnlineTraining/Modul06/Task01/source", "Mail1.txt");
        String message = null;
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            if (outputFile.exists()) {
                outputFile.createNewFile();
            }
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s1 = line.split(" : ");
                if (letter.getRecipientEmail().equalsIgnoreCase(s1[0]) &&
                        letter.getTitle().equalsIgnoreCase(s1[1]) &&
                        letter.getMessage().equalsIgnoreCase(s1[2]) &&
                        letter.getSenderEmail().equalsIgnoreCase(s1[3]) &&
                        s1[4].equalsIgnoreCase("Не прочитано")) {
                    message = s1[2];
                    for (int i = 0; i < s1.length; i++) {
                        if (i != 4) {
                            bw.write(s1[i] + " : ");
                        } else {
                            bw.write("Прочитано");
                        }
                    }
                    bw.newLine();
                } else if (letter.getRecipientEmail().equalsIgnoreCase(s1[0]) &&
                        letter.getTitle().equalsIgnoreCase(s1[1]) &&
                        letter.getMessage().equalsIgnoreCase(s1[2]) &&
                        letter.getSenderEmail().equalsIgnoreCase(s1[3]) &&
                        s1[4].equalsIgnoreCase("Прочитано")) {
                    message = s1[2];
                    for (int i = 0; i < s1.length; i++) {
                        if (i < s1.length - 1) {
                            bw.write(s1[i] + " : ");
                        } else {
                            bw.write(s1[i]);
                        }
                    }
                    bw.newLine();
                } else {
                    for (int i = 0; i < s1.length; i++) {
                        if (i < s1.length - 1) {
                            bw.write(s1[i] + " : ");
                        } else {
                            bw.write(s1[i]);
                        }
                    }
                    bw.newLine();
                }
            }
            br.close();
            bw.close();
            sourceFile.delete();
            outputFile.renameTo(sourceFile);
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public boolean notification(String email, String bookTitle) throws DAOException {
        boolean result = false;
        try (FileWriter fw = new FileWriter("E://Epam/JavaOnlineTraining/Modul06/Task01/source/Mail.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String letterData = "" + email + " : " + "Добавлено описание к книге" + " : " + "К книге " + bookTitle
                    + " добавлено описание" + " : " + "joker@gmail.com" + " : " + "Не прочитано";
            out.println();
            out.print(letterData);
            result = true;
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}


