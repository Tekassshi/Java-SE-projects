package commands;

import Interfaces.Command;
import Interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

public class RemoveById extends AbstractCommand implements Command, CommandWithArg {
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
}
