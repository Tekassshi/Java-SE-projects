package commands;

import Interfaces.Command;
import managers.CollectionManager;

import java.io.IOException;

public class Save extends AbstractCommand implements Command {
    public Save(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().save();
    }

    @Override
    public void executeFromScript() throws IOException {
        super.getCollectionManager().save();
    }
}
