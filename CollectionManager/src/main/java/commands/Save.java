package commands;

import Interfaces.Command;
import managers.CollectionManager;

public class Save extends AbstractCommand implements Command {
    public Save(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().save();
    }
}
