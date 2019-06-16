package Commands;

import Shell.Shell;

public class CdCommand extends Command {

    private String path;

    public CdCommand(String path) {
        this.path = path;
    }

    public void execute(Shell shell) {
        shell.changeDirectory(path);
    }
}
