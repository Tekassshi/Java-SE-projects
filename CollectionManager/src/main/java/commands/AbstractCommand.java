package commands;

import managers.CollectionManager;

public abstract class AbstractCommand {
    private CollectionManager collectionManager;

    public AbstractCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}
