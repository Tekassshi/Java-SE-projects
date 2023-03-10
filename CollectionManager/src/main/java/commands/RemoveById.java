package commands;

import Interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

import java.io.IOException;

public class RemoveById extends AbstractCommand implements CommandWithArg {
    public RemoveById(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        super.getCollectionManager().removeById(Integer.parseInt(super.getArgument()));
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readId(arg));
    }

    @Override
    public void executeFromScript() throws IOException {
        super.getCollectionManager().removeById(Integer.parseInt(super.getArgument()));
    }
}
