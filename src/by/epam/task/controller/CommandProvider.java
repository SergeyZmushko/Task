package by.epam.task.controller;

import by.epam.task.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("logination", new LoginationCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("getCatalog", new GetCatalogCommand());
        commands.put("addBook", new AddBookCommand());
        commands.put("removeBook", new RemoveBookCommand());
        commands.put("searchUser", new SearchUserCommand());
        commands.put("searchBookByTitle", new SearchBookByTitleCommand());
        commands.put("searchBookByAuthor", new SearchBookByAuthorCommand());
        commands.put("addDiscribe", new AddDiscribeCommand());
        commands.put("getLetters", new GetLettersCommand());
        commands.put("suggestAddBook", new SuggestAddBookCommand());
        commands.put("showMessage", new ShowMessageCommand());
        commands.put("notification", new NotificationCommand());
        commands.put("getUsers", new GetUsersCommand());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
