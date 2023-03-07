package managers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import data.Person;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Queue;

public class CollectionManager {
    private Queue<Person> collection = new ArrayDeque();

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

    public void show(){
        if (collection.size() == 0){
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        System.out.println("\n--- Collection ---\n");

        for (Person person : collection){

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

    public void updateId(int id){
        int is_exist = 0;

        if (collection.size() == 0){
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        for (Person person : collection){
            if (person.getId() == id){
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
                is_exist = 1;
                break;
            }
        }
        if (is_exist == 0){
            System.out.println(ANSI_RED + "\nPerson with given id value doesn't exist!" + ANSI_RESET);
            System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
        }
        else
            System.out.println(ANSI_GREEN + "\nPerson with id = " + id + " was successfully updated!\n");
    }

    public void removeById(int id){
        int is_exist = 0;

        if (collection.size() == 0){
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        for (Person person : collection){
            if (person.getId() == id){
                collection.remove(person);
                is_exist = 1;
                break;
            }
        }
        if (is_exist == 0){
            System.out.println(ANSI_RED + "\nPerson with given id value doesn't exist!" + ANSI_RESET);
            System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
        }
        else
            System.out.println(ANSI_GREEN + "\nPerson with id = " + id + " was successfully removed!\n");
    }

    public void clear(){
        if (collection.size() == 0){
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        collection.removeAll(collection);
        System.out.println(ANSI_GREEN + "\nPerson with id = " + id + " was successfully removed!\n");
    }

    public void save(){
        String collection_path = System.getenv("Lab5_collection");
        boolean is_exist = true;

        if (collection.size() == 0){
            System.out.println(ANSI_RED + "\nCollection is empty!\n" + ANSI_RESET);
            return;
        }

        File out_file;

        if (collection_path == null || !Files.exists(Path.of(collection_path))) {
            collection_path = System.getProperty("user.dir") + "\\src\\main\\resources\\Collection.xml";

            try {
                out_file = new File(collection_path);
                out_file.createNewFile();
            }
            catch (IOException e){
                System.out.println(ANSI_RED + "\nError creating new file. Try again.\n" + ANSI_RESET);
                return;
            }
        }

        try (FileOutputStream fos = new FileOutputStream(collection_path);
             OutputStreamWriter writer = new OutputStreamWriter(fos)){

            XmlMapper mapper = new XmlMapper();
            mapper.registerModule(new JavaTimeModule());

            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            mapper.setDateFormat(df);

            mapper.getFactory().disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String out = mapper.writer().withRootName("Collection").writeValueAsString(collection);
            writer.write(out);

            System.out.println();
            if (is_exist) {
                System.out.println(ANSI_GREEN + "Your file has been successfully written to \"" + collection_path +
                        "\"" + ANSI_RESET);
            }
            else {
                System.out.println(ANSI_RED + "Wrong environmental variable \"Lab5_collection\" value." + ANSI_RESET);
                System.out.println(ANSI_GREEN + "Your file has been successfully written to \"" + collection_path +
                        "\"" + ANSI_RESET);
            }
            System.out.println();
        }

        catch (FileNotFoundException e){
            System.out.println(ANSI_RED + "\nCheck your environmental variable \"Lab5_collection\"value, " +
                    "file doesn't exist." + ANSI_RESET);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}