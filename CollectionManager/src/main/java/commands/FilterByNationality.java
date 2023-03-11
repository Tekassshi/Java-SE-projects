package commands;

import data.Country;
import interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

import java.io.IOException;

public class FilterByNationality extends AbstractCommand implements CommandWithArg {
    public FilterByNationality(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readNationality(arg));
    }

    @Override
    public void execute() throws IOException {
        super.getCollectionManager().filterByNationality(Country.valueOf(super.getArgument()));
    }
}
