package Commands;

import Shell.Shell;

public class InvalidCommand extends Command {
    public void execute(Shell shell) {
        System.out.println("Invalid command, try again");
    }
}
