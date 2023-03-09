package Factories;

import Interfaces.Command;
import commands.*;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandFactory {
    private static CollectionManager collectionManager;

    static Map<String, Command> commands = new HashMap<>();
    static Set<String> commands_with_args = new HashSet<>();

    public static Command getCommand(String value){
        return commands.getOrDefault(value, null);
    }

    public static Set<String> getCommandsWithArgs() {
        return commands_with_args;
    }

    public static void setCollectionManager(CollectionManager collectionManager) {
        CommandFactory.collectionManager = collectionManager;

        // Loading commands classes to general commands map

        commands.put("help", new Help(collectionManager));
//      commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("add", new Add(collectionManager));
        commands.put("update", new UpdateId(collectionManager));
        commands.put("remove_by_id", new RemoveById(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("execute_script", new ExecuteScript(collectionManager));

        // Filling commands list with arguments
        commands_with_args.add("update");
        commands_with_args.add("remove_by_id");
        commands_with_args.add("execute_script");
    }
}