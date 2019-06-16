package Commands.Factory;

import Commands.*;

public class CommandFactory {

    private static final int MAX_FILENAME_SIZE = 100;

    private static final int MAX_DIR_NAME_SIZE = 100;

    public static Command getCommandForInput(String[] input) {

        /*
        As we did in Directory class, the messages i'm printing i should put them in constants in the future.
        There are to many if's, a lot of this should be parametrized too.
         */

        String command = input[0];
        if (command.equals("pwd")) {
            if (input.length > 1) {
                System.out.println("0 arguments must be passed to pwd");
                return new InvalidCommand();
            }
            return new PwdCommand();
        }
        if (command.equals("ls")) {
            if (input.length > 1) {
                System.out.println("0 arguments must be passed to ls");
                return new InvalidCommand();
            }
            return new LsCommand();
        }
        if (command.equals("touch")) {
            if (input.length < 2 || input[1].length() > MAX_FILENAME_SIZE || input.length > 2) {
                System.out.println("A filename must be provided with max length of 100 characters");
                return new InvalidCommand();
            }
            return new TouchCommand(input[1]);
        }
        if (command.equals("mkdir")) {
            if (input.length < 2 || input[1].length() > MAX_DIR_NAME_SIZE || input.length > 2) {
                System.out.println("A directory name must be provided with max length of 100 characters");
                return new InvalidCommand();
            }
            return new MkdirCommand(input[1]);
        }
        if (command.equals("quit")) {
            if (input.length > 1) {
                System.out.println("0 arguments must be passed to quit");
                return new InvalidCommand();
            }
            return new QuitCommand();
        }
        if (command.equals("cd")) {
            if (input.length < 2 || input[1].length() > MAX_DIR_NAME_SIZE) {
                System.out.println("A directory name must be provided with max length of 100 characters");
                return new InvalidCommand();
            }
            return new CdCommand(input[1]);
        }

        return new InvalidCommand();
    }
}
