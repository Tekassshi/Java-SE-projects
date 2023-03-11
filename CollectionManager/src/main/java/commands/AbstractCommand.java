package commands;

import managers.CollectionManager;

public abstract class AbstractCommand {
    private CollectionManager collectionManager;
    private String argument;
    private Object object;

    protected final String GREEN_BOLD = "\033[1;32m";
    protected final String ANSI_RED = "\u001B[31m";
    protected final String ANSI_RESET = "\u001B[0m";

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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
