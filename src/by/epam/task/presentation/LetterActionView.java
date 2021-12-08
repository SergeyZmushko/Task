package by.epam.task.presentation;

import by.epam.task.bean.Letter;

import java.util.List;

public interface LetterActionView {
    String getLetters(List<Letter> letterList);

    String suggestAddBook(Letter letter);

    String showMessage(Letter letter);

    String notification(boolean result);
}
