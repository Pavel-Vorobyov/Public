package by.vorobyov.training.controller.command;

import by.vorobyov.training.controller.command.impl.page.SingInPage;
import by.vorobyov.training.resource.CommandName;

import java.util.HashMap;
import java.util.Map;

public class CommandStorage {
    private final static CommandStorage INSTANCE = new CommandStorage();
    private final Map<String, ICommand> commandStorage = new HashMap<>();

    public static CommandStorage getInstance() {
        return INSTANCE;
    }

    private CommandStorage() {
        commandStorage.put(CommandName.SING_IN_PAGE, new SingInPage());
    }

    public ICommand getCommand(String commandName) {
        ICommand command = commandStorage.get(commandName);

        return command;
    }
}
