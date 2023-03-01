package commands;

import Interfaces.Command;
import managers.CollectionManager;

public class Show extends AbstractCommand implements Command {
    public Show(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().show();
    }
}
