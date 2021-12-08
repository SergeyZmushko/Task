package by.epam.task.menu.input;

import java.util.Scanner;

public class InputData {

    public static int enterFromConsoleInt(String message) {
        Scanner sc = new Scanner(System.in);
        int value;
        System.out.println(message);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println(message);
        }
        value = sc.nextInt();
        return value;
    }

    public static String enterFromConsoleString(String message) {
        Scanner sc = new Scanner(System.in);
        String value;
        System.out.println(message);
        while (!sc.hasNextLine()) {
            sc.next();
            System.out.println(message);
        }
        value = sc.nextLine();
        return value;
    }
}
