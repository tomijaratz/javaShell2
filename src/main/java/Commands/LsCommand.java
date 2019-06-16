package Commands;

import Shell.Shell;

public class LsCommand extends Command {
    public void execute(Shell shell) {
        shell.showCurrentDirectory();
    }
}
