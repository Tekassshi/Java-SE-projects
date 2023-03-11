package commands;

import data.Country;
import interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

import java.io.IOException;

public class RemoveAllByNationality extends AbstractCommand implements CommandWithArg {
    public RemoveAllByNationality(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readNationality(arg));
    }

    @Override
    public void execute() throws IOException {
        super.getCollectionManager().removeAllByNationality(Country.valueOf(super.getArgument()));
    }
}
