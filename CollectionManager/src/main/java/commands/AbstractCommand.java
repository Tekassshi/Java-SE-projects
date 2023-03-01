package commands;

import managers.CollectionManager;

public abstract class AbstractCommand {
    private CollectionManager collectionManager;
    private String argument;

    public AbstractCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
