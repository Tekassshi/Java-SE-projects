package app.commands;

import app.managers.CollectionManager;

public class Add extends AbstractCommand implements Command{

    public Add(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.collectionManager.add();
    }
}