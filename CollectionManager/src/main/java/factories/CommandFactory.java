package factories;

import interfaces.Command;
import commands.*;
import commands.Head;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    static Map<String, Command> commands = new HashMap<>();

    public static Command getCommand(String value){
        return commands.getOrDefault(value, null);
    }

    public static void setCollectionManager(CollectionManager collectionManager) {

        // Loading commands classes to general commands map
        commands.put("help", new Help(collectionManager));
        commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("add", new Add(collectionManager));
        commands.put("update", new UpdateId(collectionManager));
        commands.put("remove_by_id", new RemoveById(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("execute_script", new ExecuteScript(collectionManager));
        commands.put("head", new Head(collectionManager));
        commands.put("add_if_min", new AddIfMin(collectionManager));
        commands.put("remove_greater", new RemoveGreater(collectionManager));
        commands.put("remove_all_by_nationality", new RemoveAllByNationality(collectionManager));
        commands.put("filter_by_nationality", new FilterByNationality(collectionManager));
        commands.put("print_field_descending_height", new PrintFieldDescendingHeight(collectionManager));
    }
}