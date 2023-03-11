package commands;

import interfaces.Command;
import managers.CollectionManager;

public class Clear extends AbstractCommand implements Command {
    public Clear(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().clear();
    }
}
