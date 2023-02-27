package commands;

import managers.CollectionManager;

public abstract class AbstractCommand {
    CollectionManager collectionManager;

    public AbstractCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
}
