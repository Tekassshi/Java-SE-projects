package commands;

import interfaces.Command;
import commands.AbstractCommand;
import managers.CollectionManager;

import java.io.IOException;

public class Head extends AbstractCommand implements Command {
    public Head(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws IOException {
        super.getCollectionManager().head();
    }
}
