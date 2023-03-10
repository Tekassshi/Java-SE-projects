package commands;

import Interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

import java.io.IOException;

public class ExecuteScript extends AbstractCommand implements CommandWithArg {
    public ExecuteScript(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void execute() {
        if (super.getArgument() == null)
            return;

        super.getCollectionManager().executeScript(super.getArgument());
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readFile(arg));
    }

    @Override
    public void executeFromScript() throws IOException {
    }
}
