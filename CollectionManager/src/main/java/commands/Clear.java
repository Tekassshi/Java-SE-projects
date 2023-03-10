package commands;

import Interfaces.Command;
import managers.CollectionManager;

import java.io.IOException;

public class Clear extends AbstractCommand implements Command {
    public Clear(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().clear();
    }

    @Override
    public void executeFromScript() throws IOException {
        super.getCollectionManager().clear();
    }
}
