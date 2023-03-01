package commands;

import Interfaces.Command;
import Interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

public class UpdateId extends AbstractCommand implements Command, CommandWithArg {
    public UpdateId(CollectionManager collectionManager) {
        super(collectionManager);
    }
    
    @Override
    public void execute() {
        super.getCollectionManager().updateId(Integer.parseInt(super.getArgument()));
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readId(arg));
    }
}
