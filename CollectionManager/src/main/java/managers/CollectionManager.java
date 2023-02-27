package managers;

import data.Person;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Queue;

public class CollectionManager {
    Queue collection = new ArrayDeque();

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private int id = 1;

    public void help(){
        StringBuilder s = new StringBuilder(
                "\"help\" - вывести справку по доступным командам\n" +
                "\"info\" - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, " +
                        "количество элементов и т.д.)\n" +
                "\"show\" - вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "\"add {element}\" - добавить новый элемент в коллекцию\n" +
                "\"update id {element}\" - обновить значение элемента коллекции, id которого равен заданному\n" +
                "\"remove_by_id id\" - удалить элемент из коллекции по его id\n" +
                "\"clear\" - очистить коллекцию\n" +
                "\"execute_script file_name\" - считать и исполнить скрипт из указанного файла. " +
                        "В скрипте содержатся команды в таком же виде, " +
                        "в котором их вводит пользователь в интерактивном режиме.\n" +
                "\"head\" - вывести первый элемент коллекции\n" +
                "\"add_if_min {element}\" - добавить новый элемент в коллекцию, если его значение меньше, " +
                        "чем у наименьшего элемента этой коллекции\n" +
                "\"remove_greater {element}\" - удалить из коллекции все элементы, превышающие заданный\n" +
                "\"remove_all_by_nationality nationality\" - удалить из коллекции все элементы, значение поля " +
                        "nationality которого эквивалентно заданному\n" +
                "\"filter_by_nationality nationality\" - вывести элементы, значение поля nationality которых " +
                        "равно заданному\n" +
                "\"print_field_descending_height\" - вывести значения поля " +
                        "height всех элементов в порядке убывания\n" +
                "\"save\" - сохранить коллекцию в файл\n" +
                "\"exit\" - завершить программу (без сохранения в файл)\n");

        System.out.println("\n--- Reference for all commands ---\n");
        System.out.println(s);
    }

    public void add(){
        System.out.println("\n--- Adding a new person to collection ---\n");
        Person person = new Person();

        // Id
        person.setId(id);
        id += 1;

        // Name
        person.setName(InputManager.readName());

        // Coordinates
        person.setCoordinates(InputManager.readCoordinates());

        // CreationDate
        person.setCreationDate(ZonedDateTime.now());

        // Height
        person.setHeight(InputManager.readHeight());

        // Weight
        person.setWeight(InputManager.readWeight());

        // Eye color
        person.setEyeColor(InputManager.readEyeColor());

        // Nationality
        person.setNationality(InputManager.readNationality());

        // Location
        person.setLocation(InputManager.readLocation());

        collection.add(person);
        System.out.println(ANSI_GREEN + "Person was added successfully!\n");
    }
}