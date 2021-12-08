package by.epam.task.presentation.impl;

import by.epam.task.bean.Letter;
import by.epam.task.presentation.LetterActionView;
import java.util.List;

public class LetterActionViewImpl implements LetterActionView {
    @Override
    public String getLetters(List<Letter> letterList) {
        String response;
        if (!letterList.isEmpty()) {
            response = "0 Письма успешно загружены.";
        } else {
            response = "1 Ошибка получения списка писем.";
        }
        return response;
    }

    @Override
    public String suggestAddBook(Letter letter) {
        String response;
        if (letter != null) {
            response = "0 Письмо отправлено.";
        } else {
            response = "1 Ошибка, письмо не отправлено";
        }
        return response;
    }

    @Override
    public String showMessage(Letter letter) {
        String response;
        if (letter != null) {
            response = "0 Письмо прочитано.";
        } else {
            response = "1 Ошибка, письмо не прочитано.";
        }
        return response;
    }

    @Override
    public String notification(boolean result) {
        String response;
        if (result) {
            response = "0 Сообщение отправлено";
        } else {
            response = "1 Ошибка, уведомление не отправлено";
        }
        return response;
    }
}
