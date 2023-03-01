package commands;

import Interfaces.Command;
import managers.CollectionManager;

public class Help extends AbstractCommand implements Command {

    public Help(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().help();
    }
}
