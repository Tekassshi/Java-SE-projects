package commands;

import data.Person;
import interfaces.AssemblableCommand;
import interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;

public class UpdateId extends AbstractCommand implements CommandWithArg, AssemblableCommand {

    private boolean is_updatable = true;
    public UpdateId(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readId(arg));
    }

    @Override
    public void buildObject() {
        System.out.println("\nUpdating element with id = " + super.getArgument() + "\n");
        if (!super.getCollectionManager().isIdExist(Integer.parseInt(super.getArgument()))){
            System.out.println(ANSI_RED + "\nCurrent id doesn't exist!" + ANSI_RESET);
            System.out.println(ANSI_RED + "Try again\n" + ANSI_RESET);
            is_updatable = false;
            return;
        }

        Person person = new Person();

        person.setId(Integer.parseInt(super.getArgument()));
        person.setName(InputManager.readName());
        person.setCoordinates(InputManager.readCoordinates());
        person.setCreationDate(ZonedDateTime.now());
        person.setHeight(InputManager.readHeight());
        person.setWeight(InputManager.readWeight());
        person.setEyeColor(InputManager.readEyeColor());
        person.setNationality(InputManager.readNationality());
        person.setLocation(InputManager.readLocation());

        super.setObject(person);
    }

    @Override
    public void buildObjectFromScript(BufferedReader reader) throws IOException {
        System.out.println("\nUpdating element with id = " + super.getArgument() + "\n");
        Person person = new Person();

        person.setId(Integer.parseInt(super.getArgument()));
        person.setName(InputManager.readNameScript(reader));
        person.setCoordinates(InputManager.readCoordinatesScript(reader));
        person.setCreationDate(ZonedDateTime.now());
        person.setHeight(InputManager.readHeightScript(reader));
        person.setWeight(InputManager.readWeightScript(reader));
        person.setEyeColor(InputManager.readEyeColorScript(reader));
        person.setNationality(InputManager.readNationalityScript(reader));
        person.setLocation(InputManager.readLocationScript(reader));

        super.setObject(person);
    }

    @Override
    public void execute() throws IOException {
        if (is_updatable)
            super.getCollectionManager().updateId((Person) super.getObject());
    }
}
