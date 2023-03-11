package commands;

import factories.CommandFactory;
import interfaces.AssemblableCommand;
import interfaces.Command;
import interfaces.CommandWithArg;
import managers.CollectionManager;
import managers.InputManager;

import java.io.*;

public class ExecuteScript extends AbstractCommand implements CommandWithArg {

    public ExecuteScript(CollectionManager collectionManager) {
        super(collectionManager);
    }

    @Override
    public void setArg(String arg) {
        super.setArgument(InputManager.readFile(arg));
    }

    @Override
    public void execute() throws FileNotFoundException {
        String file_path = super.getArgument();

        if (file_path == null)
            return;

        System.out.println("\nExecuting user script:");

        File file = new File(file_path);
        int line = 1;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String input;

            while ((input = reader.readLine()) != null) {
                String[] values = input.split(" ");

                if (values[0].equals("exit"))
                    break;
                if (values[0].equals("execute_script")) {
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

                if (command instanceof CommandWithArg) {
                    if (values.length < 2) {
                        System.out.println(ANSI_RED + "You should input argument to this command. (Command skipped)\n"
                                + ANSI_RESET);
                        return;
                    }

                    CommandWithArg tmp = (CommandWithArg) command;
                    tmp.setArg(values[1]);
                }

                System.out.println("\nCommand \"" + values[0] + " \"executing...\n");

                if (command instanceof AssemblableCommand) {
                    AssemblableCommand tmp = (AssemblableCommand) command;
                    tmp.buildObjectFromScript(reader);
                }

                try {
                    command.execute();
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "Wrong data in script. Process will be terminated.\n" + ANSI_RESET);
                    break;
                }
                line++;
            }
        } catch (NumberFormatException | NullPointerException | IOException e) {
            System.out.println(ANSI_RED + "Wrong data in script. Process will be terminated.\n" + ANSI_RESET);
        }
    }
}