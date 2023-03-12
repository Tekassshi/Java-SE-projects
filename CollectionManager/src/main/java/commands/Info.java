package commands;

import interfaces.Command;
import managers.CollectionManager;

import java.io.IOException;

public class Info extends AbstractCommand implements Command {
    public Info(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() throws IOException {
        super.getCollectionManager().info();
    }
}
