import managers.ClientManager;

import java.io.IOException;

/**
 * Main class with one static method main();
 * */
public class Main {
    /**
     * Main method for starting all application. Runs a ClientManager main method.
     * */
    public static void main(String[] args) {
        ClientManager manager = new ClientManager();

        try {
            manager.run();
        }
        catch (IOException e){
            System.out.println("\n Ошибка потока ввода! \n");
        }
    }
}