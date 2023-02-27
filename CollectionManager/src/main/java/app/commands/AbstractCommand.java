package app.commands;

import app.managers.CollectionManager;

public abstract class AbstractCommand {
    CollectionManager collectionManager;

    public AbstractCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
}
