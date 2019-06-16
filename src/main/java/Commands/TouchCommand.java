package Commands;

import Shell.Shell;

public class TouchCommand extends Command {

    private String filename;

    public TouchCommand(String filename) {
        this.filename = filename;
    }

    public void execute(Shell shell) {
        shell.addFileToCurrentDirectory(filename);

    }
}
