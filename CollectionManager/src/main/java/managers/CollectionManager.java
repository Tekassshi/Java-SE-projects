package managers;

import Factories.CommandFactory;
import Interfaces.Command;
import Interfaces.CommandWithArg;
import Interfaces.Script;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import data.Collection;
import data.Person;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.*;

public class CollectionManager {
    private Queue<Person> collection = new ArrayDeque<>();
    private String collection_path;
    private boolean is_path_exist = false;
    private BufferedReader reader;

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private Long id = Long.valueOf(1);

    public void getCollectionPath(){
        String path = System.getenv("Lab5_collection");
        File out_file;

        if (path == null || !Files.exists(Path.of(path))) {
            collection_path = System.getProperty("user.dir") + "\\src\\main\\resources\\Collection.xml";

            try {
                out_file = new File(collection_path);
                out_file.createNewFile();

            } catch (IOException e) {
                System.out.println(ANSI_RED + "\nError creating new file. Try again.\n" + ANSI_RESET);
            }
            System.out.println(ANSI_RED + "Wrong environmental variable value, or it's doesn't exist." + ANSI_RESET);
            System.out.println(ANSI_GREEN + "New collection was created: \"" + collection_path + "\"\n" + ANSI_RESET);
            return;
        }

        collection_path = path;
        is_path_exist = true;

        System.out.println(ANSI_GREEN + "Path to collection was successfully loaded: \""
                + collection_path + "\"\n" + ANSI_RESET);
    }

    public void help() {
        StringBuilder s = new StringBuilder(
                "\"help\" - вывести справку по доступным командам\n" +
                        "\"info\" - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, " +
                        "количество элементов и т.д.)\n" +
                        "\"show\" - вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "\"add\" - добавить новый элемент в коллекцию\n" +
                        "\"update id\" - обновить значение элемента коллекции, id которого равен заданному\n" +
                        "\"remove_by_id id\" - удалить элемент из коллекции по его id\n" +
                        "\"clear\" - очистить коллекцию\n" +
                        "\"execute_script file_name\" - считать и исполнить скрипт из указанного файла. " +
                        "В скрипте содержатся команды в таком же виде, " +
                        "в котором их вводит пользователь в интерактивном режиме.\n" +
                        "\"head\" - вывести первый элемент коллекции\n" +
                        "\"add_if_min\" - добавить новый элемент в коллекцию, если его значение меньше, " +
                        "чем у наименьшего элемента этой коллекции\n" +
                        "\"remove_greater\" - удалить из коллекции все элементы, превышающие заданный\n" +
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

    public void show() {
        if (collection.size() == 0) {
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        System.out.println("\n--- Collection ---\n");

        for (Person person : collection) {

            System.out.println("Id: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Coordinates: x = \"" + person.getCoordinates().getX() + "\", y = \"" +
                    person.getCoordinates().getY() + "\"");
            System.out.println("Creation date: " + person.getCreationDate());
            System.out.println("Height: " + person.getHeight());
            System.out.println("Weight: " + person.getWeight());
            System.out.println("Eye color: " + person.getEyeColor());
            System.out.println("Nationality: " + person.getNationality());
            System.out.println("Location: x = \"" + person.getLocation().getX() + "\", y = \"" +
                    person.getLocation().getY() + "\", z = \"" + person.getLocation().getZ() + "\"");
            System.out.println("");
        }
    }

    public void add(int key) throws IOException {
        System.out.println("\n--- Adding a new person to collection ---\n");

        Person person = new Person();

        // Id
        person.setId(id);
        id += 1;

        // Name
        if (key == 0)
            person.setName(InputManager.readName());
        else
            person.setName(InputManager.readNameScript(reader));

        // Coordinates
        if (key == 0)
            person.setCoordinates(InputManager.readCoordinates());
        else
            person.setCoordinates(InputManager.readCoordinatesScript(reader));


        // CreationDate
        person.setCreationDate(ZonedDateTime.now());

        // Height
        if (key == 0)
            person.setHeight(InputManager.readHeight());
        else
            person.setHeight(InputManager.readHeightScript(reader));

        // Weight
        if (key == 0)
            person.setWeight(InputManager.readWeight());
        else
            person.setWeight(InputManager.readWeightScript(reader));

        // Eye color
        if (key == 0)
            person.setEyeColor(InputManager.readEyeColor());
        else
            person.setEyeColor(InputManager.readEyeColorScript(reader));

        // Nationality
        if (key == 0)
            person.setNationality(InputManager.readNationality());
        else
            person.setNationality(InputManager.readNationalityScript(reader));

        // Location
        if (key == 0)
            person.setLocation(InputManager.readLocation());
        else
            person.setLocation(InputManager.readLocationScript(reader));

        collection.add(person);
        System.out.println(ANSI_GREEN + "Person was added successfully!\n" + ANSI_RESET);
    }

    public void updateId(int key, int id) throws IOException {
        int is_exist = 0;

        if (collection.size() == 0) {
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        for (Person person : collection) {
            if (person.getId() == id) {
                // Name
                if (key == 0)
                    person.setName(InputManager.readName());
                else
                    person.setName(InputManager.readNameScript(reader));

                // Coordinates
                if (key == 0)
                    person.setCoordinates(InputManager.readCoordinates());
                else
                    person.setCoordinates(InputManager.readCoordinatesScript(reader));

                // CreationDate
                person.setCreationDate(ZonedDateTime.now());

                // Height
                if (key == 0)
                    person.setHeight(InputManager.readHeight());
                else
                    person.setHeight(InputManager.readHeightScript(reader));

                // Weight
                if (key == 0)
                    person.setWeight(InputManager.readWeight());
                else
                    person.setWeight(InputManager.readWeightScript(reader));

                // Eye color
                if (key == 0)
                    person.setEyeColor(InputManager.readEyeColor());
                else
                    person.setEyeColor(InputManager.readEyeColorScript(reader));

                // Nationality
                if (key == 0)
                    person.setNationality(InputManager.readNationality());
                else
                    person.setNationality(InputManager.readNationalityScript(reader));

                // Location
                if (key == 0)
                    person.setLocation(InputManager.readLocation());
                else
                    person.setLocation(InputManager.readLocationScript(reader));

                is_exist = 1;
                break;
            }
        }
        if (is_exist == 0) {
            System.out.println(ANSI_RED + "\nPerson with given id value doesn't exist!" + ANSI_RESET);
            System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
        } else
            System.out.println(ANSI_GREEN + "\nPerson with id = " + id + " was successfully updated!\n");
    }

    public void removeById(int id) {
        int is_exist = 0;

        if (collection.size() == 0) {
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        for (Person person : collection) {
            if (person.getId() == id) {
                collection.remove(person);
                is_exist = 1;
                break;
            }
        }
        if (is_exist == 0) {
            System.out.println(ANSI_RED + "\nPerson with given id value doesn't exist!" + ANSI_RESET);
            System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
        } else
            System.out.println(ANSI_GREEN + "\nPerson with id = " + id + " was successfully removed!\n" + ANSI_RESET);
    }

    public void clear() {
        if (collection.size() == 0) {
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        collection.removeAll(collection);
        id = Long.valueOf(1);
        System.out.println(ANSI_GREEN + "\nCollection was successfully cleared.\n" + ANSI_RESET);
    }

    public void save() {

        try (FileOutputStream fos = new FileOutputStream(collection_path);
             OutputStreamWriter writer = new OutputStreamWriter(fos)) {

            XmlMapper mapper = new XmlMapper();
            mapper.registerModule(new JavaTimeModule());

            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            mapper.setDateFormat(df);

            mapper.getFactory().disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            Collection collection_wrapper = new Collection();
            collection_wrapper.setCollection(collection);

            mapper.writeValue(writer, collection_wrapper);

            System.out.println(ANSI_GREEN + "\nYour collection was successfully saved.\n" + ANSI_RESET);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() {
        if (!is_path_exist)
            return;

        File file = new File(collection_path);
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());

        Collection tmp;

        try {
            tmp = mapper.readValue(file, Collection.class);
        }
        catch (InvalidFormatException e){
            System.out.println(ANSI_RED + "Wrong data type in \"" + collection_path + "\"." + ANSI_RESET);
            System.out.println(ANSI_RED + e.getLocation().toString().replaceAll("\\[|\\]", "")
                    + ANSI_RESET + "\n");
            System.out.println(ANSI_GREEN + "A new empty collection has been created.\n" + ANSI_RESET);
            tmp = new Collection();
            collection = tmp.getCollection();
            return;
        }
        catch (IOException e){
            System.out.println(ANSI_RED + "Wrong XML format \"" + collection_path + "\"." + ANSI_RESET);
            System.out.println(ANSI_GREEN + "A new empty collection has been created.\n" + ANSI_RESET);
            tmp = new Collection();
            collection = tmp.getCollection();
            return;
        }

        collection = tmp.getCollection();

        System.out.println("\nChecking loaded collection data...\n");
        checkId();
        setNextId();
    }

    private void checkId(){
        Map<Long, Integer> map = new HashMap<>();
        Long max = Long.valueOf(0);
        List<Person> to_delete = new LinkedList<>();

        for (Person person : collection){
            Long tmp_id = person.getId();
            map.put(tmp_id, map.getOrDefault(tmp_id, 0) + 1);
            max = Math.max(max, tmp_id);

            if (map.get(person.getId()) > 1) {
                System.out.println(ANSI_RED + "Person with id: " + tmp_id + " is already exists." + ANSI_RESET);
                System.out.println(ANSI_RED + "Node will be removed.\n" + ANSI_RESET);
                to_delete.add(person);
            }
        }

        for (Person person: to_delete)
            collection.remove(person);
    }

    private void setNextId(){
        Long max = Long.valueOf(0);

        for (Person person : collection){
            max = Math.max(max, person.getId());
        }
        id = max + 1;
    }

    public void executeScript(String file_path){
        System.out.println(ANSI_GREEN + "\nExecuting user script:" + ANSI_RESET);
        if (file_path == null)
            return;

        File file = new File(file_path);
        int line = 1;

        try (FileReader fileReader = new FileReader(file);
              BufferedReader reader = new BufferedReader(fileReader)){

            this.reader = reader;
            String input;
            int is_correct = 1;

            while ((input = reader.readLine()) != null){
                String[] values = input.split(" ");

                if (values[0].equals("exit"))
                    break;
                if (values[0].equals("execute_script")){
                    System.out.println(ANSI_RED + "Command \"execute_script\" doesn't supported in current mode. " +
                            "(Command skipped)" + ANSI_RESET);
                    continue;
                }

                Command command = CommandFactory.getCommand(values[0]);

                if (command == null) {
                    System.out.println(ANSI_RED + "Line: " + line + ANSI_RESET);
                    System.out.println(ANSI_RED + "Wrong command.\n" + ANSI_RESET);
                    return;
                }

                if (CommandFactory.getCommandsWithArgs().contains(values[0])){
                    if (values.length < 2) {
                        System.out.println(ANSI_RED + "You should input argument to this command. (Command skipped)\n"
                                + ANSI_RESET);
                        return;
                    }

                    CommandWithArg tmp = (CommandWithArg) command;
                    tmp.setArg(values[1]);
                }
                Script tmp = (Script) command;
                System.out.println("\nCommand \"" + values[0] + " \"executing...\n");

                try {
                    tmp.executeFromScript();
                }
                catch (Exception e){
                    System.out.println(ANSI_RED + "Wrong data in script. Process will be terminated.\n" + ANSI_RESET);
                    is_correct = 0;
                    break;
                }
                line++;
            }
            if (is_correct != 0)
                System.out.println(ANSI_GREEN + "\nScript was successfully executed.\n" + ANSI_RESET);

        } catch (IOException e){
            System.out.println(ANSI_RED + "Wrong data in script" + ANSI_RESET);
        }
    }
}