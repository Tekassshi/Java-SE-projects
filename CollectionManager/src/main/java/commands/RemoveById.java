package commands;

import managers.CollectionManager;

public class RemoveById extends AbstractCommand implements Command{
    private int remove_val;

    public RemoveById(CollectionManager collectionManager, int id) {
        super(collectionManager);
        remove_val = id;
    }

    @Override
    public void execute() {
        super.getCollectionManager().removeById(remove_val);
    }
}
