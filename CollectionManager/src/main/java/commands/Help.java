package commands;

import Interfaces.Command;
import managers.CollectionManager;

import java.io.IOException;

public class Help extends AbstractCommand implements Command {

    public Help(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().help();
    }

    @Override
    public void executeFromScript() throws IOException {
        super.getCollectionManager().help();
    }
}
