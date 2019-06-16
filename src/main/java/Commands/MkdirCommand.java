package Commands;

import Shell.Shell;

public class MkdirCommand extends Command {

    private String directoryName;

    public MkdirCommand(String directoryName) {
        this.directoryName = directoryName;
    }

    public void execute(Shell shell) {
        shell.makeDirectory(directoryName);
    }
}
