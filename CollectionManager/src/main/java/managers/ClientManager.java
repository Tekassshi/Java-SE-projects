package managers;

import commands.Add;
import commands.Command;
import commands.Help;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Мы должны создать объект команды, в котором будут находиться все инструкции для выполнения,
 * и передать его серверу.
 *
 * ??? Создать класс CollectionManager на клиенте с пустыми методами, а когда передаём на сервер,
 * аналогичный класс содержит реализацию этих методов ???
 *
 */

public class ClientManager {
    private final String GREEN_BOLD = "\033[1;32m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";

    public void run() throws IOException {
        System.out.println(GREEN_BOLD + "\n--- Welcome to collection manager! ---\n" + ANSI_RESET);
        System.out.println("(type \"help\" - to get reference, \"exit\" - to terminate)\n");

        CollectionManager collectionManager = new CollectionManager();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while (true){
            System.out.print(GREEN_BOLD + ">>> " + ANSI_RESET);
            String[] values = reader.readLine().split(" ");
            int is_exit = 0;

            switch (values[0]){
                case "help":
                    Command help = new Help(collectionManager);
                    help.execute();
                    break;

                case "info":

                    break;
                case "show":

                    break;
                case "add":
                    Command add = new Add(collectionManager);
                    add.execute();
                    break;
                case "update_id":

                    break;
                case "remove_by_id":

                    break;
                case "clear":

                    break;
                case "save":

                    break;
                case "execute_script":

                    break;
                case "head":

                    break;
                case "add_if_min":

                    break;
                case "remove_greater":

                    break;
                case "remove_all_by_nationality":

                    break;
                case "filter_by_nationality":

                    break;
                case "print_field_descending_height":

                    break;
                case "exit":
                    is_exit = 1;
                    break;

                default:
                    System.out.println(ANSI_RED + "\nWrong command! Try again.\n" + ANSI_RESET);
                    break;
            }
            if (is_exit == 1)
                break;
        }
    }

}
