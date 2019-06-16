package Commands;

import Shell.Shell;

public class QuitCommand extends Command {
    public void execute(Shell shell) {
        System.exit(0);
    }
}
