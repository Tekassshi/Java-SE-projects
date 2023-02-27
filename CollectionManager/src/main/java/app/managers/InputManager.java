package app.managers;

import app.data.Coordinates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
                System.out.print("\nEnter \"X\" coord: ");
                int x = Integer.parseInt(reader.readLine());
                if (x <= -783)
                    throw new NumberFormatException();
                coordinates.setX(x);

                System.out.print("Enter \"Y\" coord: ");
                Long y = Long.parseLong(reader.readLine());
                coordinates.setY(y);
                System.out.println("");

                return coordinates;
            }
            catch (NumberFormatException | IOException e){
                System.out.println(ANSI_RED + "\nWrong coordinates format!\n(\"X\" should be integer number, " +
                        "that > -783, \"Y\" should be Long type number." + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
            }
        }
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
                System.out.println(ANSI_RED + "\nWrong height format!\n(height should be > 0, and " +
                        "only digits supported)" + ANSI_RESET);
                System.out.println(ANSI_RED + "Try again.\n" + ANSI_RESET);
            }
        }
    }
}