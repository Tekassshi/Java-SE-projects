package commands;

import managers.CollectionManager;

public class UpdateId extends AbstractCommand implements Command{
    private int update_val;

    public UpdateId(CollectionManager collectionManager, int update_val) {
        super(collectionManager);
        this.update_val = update_val;
    }

    @Override
    public void execute() {
        super.getCollectionManager().updateId(update_val);
    }
}
