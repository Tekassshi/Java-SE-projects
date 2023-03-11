package managers;

import data.Color;
import data.Coordinates;
import data.Country;
import data.Location;

import java.io.*;
import java.util.InputMismatchException;

public class InputManager {
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader reader = new BufferedReader(isr);

    public static String readName(){
        while (true){
            try {
                System.out.print("Enter person name: ");
                String name;
                name = reader.readLine();

                if (!isWord(name) || name.length() == 0)
                    throw new IOException();
                return name;
            }
            catch (IOException e){
                System.out.println(ANSI_RED + "\nWrong name format!\n(Name should contain at least 1 symbol and " +
                        "only letters supported)" + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
            }
        }
    }

    public static String readNameScript(BufferedReader reader) throws IOException, InputMismatchException {
        String name;
        name = reader.readLine();

        if (!isWord(name) || name.length() == 0)
            throw new InputMismatchException();
        return name;
    }

    public static boolean isWord(String word){
        for (int i = 0; i < word.length(); i++){
            if (!Character.isLetter(word.charAt(i)))
                return false;
        }
        return true;
    }

    public static Coordinates readCoordinates(){
        Coordinates coordinates = new Coordinates();

        while (true){
            try {
                System.out.print("\nEnter \"X\" coord (integer value): ");
                int x = Integer.parseInt(reader.readLine());
                if (x <= -783)
                    throw new NumberFormatException();
                coordinates.setX(x);

                System.out.print("Enter \"Y\" coord (long integer value): ");
                Long y = Long.parseLong(reader.readLine());
                coordinates.setY(y);
                System.out.println("");

                return coordinates;
            }
            catch (NumberFormatException | IOException e){
                System.out.println(ANSI_RED + "\nWrong coordinates format!\n(\"X\" should be integer number, " +
                        "that > -783, \"Y\" should be long integer number." + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again." + ANSI_RESET);
            }
        }
    }

    public static Coordinates readCoordinatesScript(BufferedReader reader) throws IOException, NumberFormatException {
        Coordinates coordinates = new Coordinates();

        int x = Integer.parseInt(reader.readLine());

        if (x <= -783)
            throw new NumberFormatException();

        coordinates.setX(x);
        Long y = Long.parseLong(reader.readLine());
        coordinates.setY(y);
        return coordinates;
    }

    public static Integer readHeight(){
        while (true){
            try {
                System.out.print("Enter person height: ");
                Integer height = Integer.parseInt(reader.readLine());

                if (height <= 0)
                    throw new IOException();

                return height;
            }
            catch (NumberFormatException | IOException e){
                System.out.println(ANSI_RED + "\nWrong height format!\n(height should be integer > 0, and " +
                        "only digits supported)" + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
            }
        }
    }

    public static Integer readHeightScript(BufferedReader reader) throws IOException {
        Integer height = Integer.parseInt(reader.readLine());
        if (height <= 0)
            throw new IOException();
        return height;
    }

    public static Float readWeight(){
        while (true){
            try {
                System.out.print("Enter person weight: ");
                Float weight = Float.parseFloat(reader.readLine().replaceAll(",", "."));

                if (weight <= 0)
                    throw new IOException();

                System.out.println("");
                return weight;
            }
            catch (NumberFormatException | IOException e){
                System.out.println(ANSI_RED + "\nWrong weight format!\n(weight should be decimal value > 0)"
                        + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
            }
        }
    }

    public static Float readWeightScript(BufferedReader reader) throws IOException {
        Float weight = Float.parseFloat(reader.readLine().replaceAll(",", "."));

        if (weight <= 0)
            throw new IOException();

        return weight;
    }

    public static Color readEyeColor(){
        while (true){
            try {
                System.out.print("Enter person eye color (GREEN, RED, BLACK, BLUE, YELLOW): ");
                Color eye_color = Color.valueOf(reader.readLine().toUpperCase());

                return eye_color;
            }
            catch (IOException | IllegalArgumentException | NullPointerException e){
                System.out.println(ANSI_RED + "\nWrong color value!\n(you can choose one of the values " +
                        "GREEN, RED, BLACK, BLUE, YELLOW)" + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
            }
        }
    }

    public static Color readEyeColorScript(BufferedReader reader) throws IOException {
        Color eye_color = Color.valueOf(reader.readLine().toUpperCase());

        return eye_color;
    }

    public static Country readNationality(){
        while (true){
            try {
                System.out.print("Enter person nationality (RUSSIA, FRANCE, THAILAND, NORTH_KOREA): ");
                Country nationality = Country.valueOf(reader.readLine().toUpperCase());

                return nationality;
            }
            catch (IOException | IllegalArgumentException | NullPointerException e){
                System.out.println(ANSI_RED + "\nWrong nationality value!\n(you can choose one of the values " +
                        "RUSSIA, FRANCE, THAILAND, NORTH_KOREA)" + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
            }
        }
    }

    public static String readNationality(String nationality){
        int f = 0;

        while (true){
            try {
                if (f == 1) {
                    System.out.print("Enter person nationality (RUSSIA, FRANCE, THAILAND, NORTH_KOREA): ");
                    nationality = reader.readLine().toUpperCase();
                }
                Country tmp = Country.valueOf(nationality.toUpperCase());
                return nationality.toUpperCase();
            }
            catch (IOException | IllegalArgumentException | NullPointerException e){
                System.out.println(ANSI_RED + "\nWrong nationality value!\n(you can choose one of the values " +
                        "RUSSIA, FRANCE, THAILAND, NORTH_KOREA)" + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
                f = 1;
            }
        }
    }

    public static Country readNationalityScript(BufferedReader reader) throws IOException {
        Country nationality = Country.valueOf(reader.readLine().toUpperCase());
        return nationality;
    }

    public static Country readNationalityScript(String nat) throws IOException {
        Country nationality = Country.valueOf(nat.toUpperCase());
        return nationality;
    }

    public static Location readLocation(){
        Location location = new Location();

        while (true){
            try {
                System.out.print("\nEnter \"X\" coord (Float value): ");
                Float x = Float.parseFloat(reader.readLine().replaceAll(",", "."));
                location.setX(x);

                System.out.print("Enter \"Y\" coord (Integer value): ");
                Integer y = Integer.parseInt(reader.readLine());
                location.setY(y);

                System.out.print("Enter \"Z\" coord (Double value): ");
                Double z = Double.parseDouble(reader.readLine().replaceAll(",", "."));
                location.setZ(z);
                System.out.println("");

                return location;
            }
            catch (NumberFormatException | IOException e){
                System.out.println(ANSI_RED + "\nWrong location format!\n(\"X\" should be Float number, "  +
                        "\"Y\" should be Integer number, " +
                        "\"Z\" should be Double number." +ANSI_RESET);
                System.out.println(ANSI_RED + "Try again." + ANSI_RESET);
            }
        }
    }

    public static Location readLocationScript(BufferedReader reader) throws IOException {
        Location location = new Location();

        Float x = Float.parseFloat(reader.readLine().replaceAll(",", "."));
        location.setX(x);

        Integer y = Integer.parseInt(reader.readLine());
        location.setY(y);

        Double z = Double.parseDouble(reader.readLine().replaceAll(",", "."));
        location.setZ(z);
        return location;
    }

    public static String readId(String id){
        int out = 0;
        int f = 0;
        while (true){
            try {
                if (f == 1) {
                    System.out.print("Enter id value: ");
                    id = reader.readLine();
                }
                out = Integer.parseInt(id);

                if (out <= 0)
                    throw new NumberFormatException();

                return id;
            }
            catch (IOException | NumberFormatException e){
                System.out.println(ANSI_RED + "\nWrong id value!\n(Id should be > 0 and contain " +
                        "only digits)" + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
                f = 1;
            }
        }
    }

    public static String readFile(String file_name) {
        String file_dir = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        String file_path = file_dir + file_name;

        File file = new File(file_path);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            return file_path;
        }
        catch (FileNotFoundException e){
            System.out.println(ANSI_RED + "\nFile called \"" + file_name + "\" not found in \"" + file_dir
                    +"\"."+ ANSI_RESET);
            System.out.println(ANSI_RED + "Your file should be located in \"" + file_dir + "\". " +
                    "Please, create file with script in this directory and try again."+ ANSI_RESET + "\n");
            return null;
        }
    }
}