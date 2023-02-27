package app.commands;

import app.managers.CollectionManager;

public class Help extends AbstractCommand implements Command{

    public Help(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.collectionManager.help();
    }
}
