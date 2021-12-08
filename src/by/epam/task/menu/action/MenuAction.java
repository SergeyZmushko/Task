package by.epam.task.menu.action;

import by.epam.task.bean.Book;
import by.epam.task.bean.Letter;
import by.epam.task.bean.User;
import by.epam.task.menu.input.InputData;
import by.epam.task.menu.view.MenuView;

import java.util.List;

public class MenuAction {

    public void start() {
        int key;
        do {
            MenuView.printMainMenu();
            switch (key = InputData.enterFromConsoleInt(">>")) {
                case 1:
                    User user = UserAction.processLogin();
                    if (user != null && user.getUserType().getValue().equalsIgnoreCase("admin")) {
                        System.out.println("Добро пожаловать " + user.getUsername());
                        MenuView.underMenu(user);
                        do {
                            key = InputData.enterFromConsoleInt("Выберите пункт меню >>");
                            switch (key) {
                                case 1:
                                    List<Book> books;
                                    books = CatalogAction.processGetCatalog();
                                    System.out.println(books);
                                    break;
                                case 2:
                                    Book book;
                                    book = BookAction.processSearchBookByTitle();
                                    if (book != null) {
                                        System.out.println("Вот Ваша книга " + book);
                                    }
                                    break;
                                case 3:
                                    List<Book> books1;
                                    books1 = BookAction.processSearchBookByAuthor();
                                    if (books1 != null) {
                                        System.out.println(books1);
                                    }
                                    break;
                                case 4:
                                    UserAction.processRegistration();
                                    break;
                                case 5:
                                    CatalogAction.processAddBook();
                                    break;
                                case 6:
                                    CatalogAction.processRemoveBook();
                                    break;
                                case 7:
                                    String bookTitle = BookAction.processAddDescription();
                                    List<User> users = UserAction.processGetUsers();
                                    MailAction.processNotification(users, bookTitle);
                                    break;
                                case 8:
                                    System.out.println("Выберите письмо для прочтения");
                                    List<Letter> letterList;
                                    String email = user.getEmail();
                                    letterList = MailAction.processGetLetters(email);
                                    int i = 1;
                                    for (Letter letter : letterList) {
                                        System.out.println(i + ". " + letter);
                                        i++;
                                    }
                                    do {
                                        key = InputData.enterFromConsoleInt("Введите номер письма >>");
                                        if (key > 0 && key <= letterList.size()) {
                                            System.out.println(MailAction.showMessage(letterList, key));
                                            System.out.println("0. Назад.");
                                        }
                                        if (key == 0) {
                                            key = 1;
                                            break;
                                        }
                                    } while (key > 0);
                                case 0:
                                    break;
                            }
                        } while (key != 0);
                    } else if (user != null && user.getUserType().getValue().equalsIgnoreCase("user")) {
                        MenuView.underMenu(user);
                        do {
                            switch (key = InputData.enterFromConsoleInt("Выберите пункт меню >>")) {
                                case 1:
                                    List<Book> books;
                                    books = CatalogAction.processGetCatalog();
                                    System.out.println(books);
                                    break;
                                case 2:
                                    Book book;
                                    book = BookAction.processSearchBookByTitle();
                                    System.out.println("Вот Ваша книга " + book);
                                    break;
                                case 3:
                                    List<Book> books1;
                                    books1 = BookAction.processSearchBookByAuthor();
                                    System.out.println(books1);
                                    break;
                                case 4:
                                    MailAction.suggestAddBook(user);
                                    break;
                                case 8:
                                    System.out.println("Выберите письмо для прочтения");
                                    List<Letter> letterList;
                                    String email = user.getEmail();
                                    letterList = MailAction.processGetLetters(email);
                                    int i = 1;
                                    for (Letter letter : letterList) {
                                        System.out.println(i + ". " + letter);
                                        i++;
                                    }
                                    do {
                                        key = InputData.enterFromConsoleInt("Введите номер письма >>");
                                        if (key > 0 && key <= letterList.size()) {
                                            System.out.println(MailAction.showMessage(letterList, key));
                                            System.out.println("0. Назад.");
                                        }
                                        if (key == 0) {
                                            key = 1;
                                            break;
                                        }
                                    } while (key > 0);
                                case 0:
                                    break;
                            }
                        } while (key != 0);
                    } else {
                        System.out.println("Неверное имя пользователя или пароль.");
                        break;
                    }
                case 2:
                    System.out.println("До свидания!");
                    break;
            }
        } while (key == 1);
    }
}
