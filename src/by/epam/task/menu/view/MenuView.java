package by.epam.task.menu.view;

import by.epam.task.bean.User;

public class MenuView {

    public static void printMainMenu() {
        System.out.println("Добро пожаловать в домашнюю библиотеку!");
        System.out.println("Выберите действие: \n" +
                "1. Авторизация. \n" +
                "2. Выход из программы.");
    }

    public static void underMenu(User user) {
        System.out.println("Выберите действие: \n" +
                "1. Просмотр каталога. \n" +
                "2. Поиск книги по названию. \n" +
                "3. Поиск книг по автору ");
        if (user.getUserType().getValue().equalsIgnoreCase("admin")) {
            System.out.println(
                    "4. Зарегистрировать пользователя \n" +
                            "5. Добавить книгу в каталог. \n" +
                            "6. Удалить книгу из каталога. \n" +
                            "7. Добавить описание книги. ");
        } else if (user.getUserType().getValue().equalsIgnoreCase("user")) {
            System.out.println(
                    "4. Предложить добавить книгу.");
        }
        System.out.println(
                "8. Проверить почту. \n" +
                        "0. Выход из программы.");
    }
}
