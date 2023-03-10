package commands;

import Interfaces.Command;
import managers.CollectionManager;

import java.io.IOException;

public class Show extends AbstractCommand implements Command {
    public Show(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().show();
    }

    @Override
    public void executeFromScript() throws IOException {
        super.getCollectionManager().show();
    }
}
