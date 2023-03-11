package commands;

import interfaces.Command;
import managers.CollectionManager;

import java.io.IOException;

public class PrintFieldDescendingHeight extends AbstractCommand implements Command {
    public PrintFieldDescendingHeight(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws IOException {
        super.getCollectionManager().printFieldDescendingHeight();
    }
}
