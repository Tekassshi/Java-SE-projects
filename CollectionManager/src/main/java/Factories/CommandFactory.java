package Factories;

import Interfaces.Command;
import commands.*;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandFactory {
    static CollectionManager collectionManager = new CollectionManager();

    static Map<String, Command> commands = new HashMap<>();
    static Set<String> commands_with_args = new HashSet<>();

    // Loading commands classes to general commands map
    static {
        commands.put("help", new Help(collectionManager));
//        commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("add", new Add(collectionManager));
        commands.put("update", new UpdateId(collectionManager));
        commands.put("remove_by_id", new RemoveById(collectionManager));
//        commands.put("help", new Help(collectionManager));
//        commands.put("help", new Help(collectionManager));
//        commands.put("help", new Help(collectionManager));
//        commands.put("help", new Help(collectionManager));
    }

    // Filling commands list with arguments
    static {
        commands_with_args.add("update");
        commands_with_args.add("remove_by_id");
    }

    public static Command getCommand(String value){
        return commands.getOrDefault(value, null);
    }

    public static Set<String> getCommandsWithArgs() {
        return commands_with_args;
    }
}