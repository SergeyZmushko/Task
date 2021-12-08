package by.epam.task.controller;


public class LibraryController implements Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    @Override
    public String doAction(String request) {
        String[] params;
        String commandName;
        params = request.split("\\^");
        commandName = params[0];

        //находим команду, которая может выполнить реквест
        Command currentComand = commandProvider.getCommand(commandName);
        String response;

        //команда выполняет реквест
        response = currentComand.execute(params);

        return response;
    }
}
