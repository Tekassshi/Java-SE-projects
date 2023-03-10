package commands;

import Interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

import java.io.IOException;

public class UpdateId extends AbstractCommand implements CommandWithArg {
    public UpdateId(CollectionManager collectionManager) {
        super(collectionManager);
    }
    
    @Override
    public void execute() throws IOException {
        super.getCollectionManager().updateId(0, Integer.parseInt(super.getArgument()));
    }

    @Override
    public void executeFromScript() throws IOException {
        super.getCollectionManager().updateId(1, Integer.parseInt(super.getArgument()));
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readId(arg));
    }
}
