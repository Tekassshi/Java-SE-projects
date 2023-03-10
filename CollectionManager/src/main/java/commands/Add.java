package commands;

import Interfaces.Command;
import managers.CollectionManager;

import java.io.IOException;

public class Add extends AbstractCommand implements Command {

    public Add(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws IOException {
        super.getCollectionManager().add(0);
    }

    @Override
    public void executeFromScript() throws IOException {
        super.getCollectionManager().add(1);
    }
}