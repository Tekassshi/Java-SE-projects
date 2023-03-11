package commands;

import interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

public class RemoveById extends AbstractCommand implements CommandWithArg {
    public RemoveById(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readId(arg));
    }

    @Override
    public void execute() {
        super.getCollectionManager().removeById(Integer.parseInt(super.getArgument()));
    }
}
