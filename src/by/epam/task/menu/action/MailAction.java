package by.epam.task.menu.action;

import by.epam.task.bean.Book;
import by.epam.task.bean.Letter;
import by.epam.task.bean.User;
import by.epam.task.controller.LibraryController;
import by.epam.task.menu.input.InputData;
import by.epam.task.service.LetterService;
import by.epam.task.service.ServiceException;
import by.epam.task.service.impl.LetterServiceImpl;

import java.util.List;

public class MailAction {
    public static List<Letter> processGetLetters(String login) {
        System.out.println("Почта.");
        LibraryController controller = new LibraryController();
        List<Letter> letterList = null;

        String request;

        request = "getLetters^login=" + login;

        String response;

        response = controller.doAction(request);
        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            LetterService letterService = new LetterServiceImpl();
            try {
                letterList = letterService.getLetters(login);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Писем не найдено.");
        }
        return letterList;
    }

    public static void suggestAddBook(User user) {
        System.out.println("Предложить добавить книгу.");
        LibraryController controller = new LibraryController();

        String title = InputData.enterFromConsoleString("Введите название книги >>");
        String author = InputData.enterFromConsoleString("Введите имя автора книги >>");
        String description = InputData.enterFromConsoleString("Введите описание >>");
        String bookType = null;
        System.out.println("1. Электронная. \n" +
                "2. Бумажная.");
        int type = InputData.enterFromConsoleInt("Выберите тип книги >>");
        if (type == 1) {
            bookType = Book.BookType.EBOOK.getValue();
        } else if (type == 2) {
            bookType = Book.BookType.PAPERBOOK.getValue();
        }
        String message = "Название: " + title + ", автор: " + author + ", описание: " + description + ", тип книги: " + bookType;

        String request;
        request = "suggestAddBook^e-mail получателя=joker@gmail.com" + "^title=Добавление новой книги." + "^message=" + message + "^e-mail отправителя=" + user.getEmail();

        String response;
        response = controller.doAction(request);

        String result = response.split("\\s+")[0];
        if (result.equalsIgnoreCase("0")) {
            System.out.println("Предложение отправлено.");
        } else {
            System.out.println("Ошибка.");
        }
    }

    public static String showMessage(List<Letter> letterList, int key) {
        LibraryController controller = new LibraryController();
        Letter letter = null;
        for (int i = 0; i < letterList.size(); i++) {
            if (i == key - 1) {
                letter = letterList.get(i);
            }
        }

        String recepientEmail = letter.getRecipientEmail();
        String title = letter.getTitle();
        String letterMessage = letter.getMessage();
        String senderEmail = letter.getSenderEmail();
        String type = letter.getLetterType().getValue();

        String request;
        request = "showMessage^получатель=" + recepientEmail + "^тема=" + title + "^сообщение=" + letterMessage + "^отправитель=" + senderEmail + "^тип письма=" + type;

        String response;
        response = controller.doAction(request);

        String message = null;
        String result = response.split("\\s")[0];
        if (result.equalsIgnoreCase("0")) {
            LetterService letterService = new LetterServiceImpl();
            System.out.println("Сообщение:");
            try {
                message = letterService.showMessage(letter);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Ошибка");
            return null;
        }
        return message;
    }

    public static void processNotification(List<User> users, String bookTitle) {
        LibraryController controller = new LibraryController();
        String[] results = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {

            String request = "notification^e-mail=" + users.get(i).getEmail() + "^bookTitle=" + bookTitle;

            String response = controller.doAction(request);

            String result = response.split("\\s")[0];
            results[i] = result;
        }
        boolean result = false;
        for (String item : results) {
            if (item.equalsIgnoreCase("0")) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        if (result) {
            System.out.println("Уведомления отправлены пользователям на e-mail.");
        } else {
            System.out.println("Произошла ошибка.");
        }
    }
}
