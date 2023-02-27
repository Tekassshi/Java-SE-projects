package app;

import app.managers.ClientManager;

import java.io.IOException;

public class Main {
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