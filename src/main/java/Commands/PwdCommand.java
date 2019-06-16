package Commands;

import Shell.Shell;

import java.util.List;

public class PwdCommand extends Command {
    public void execute(Shell shell) {
        List<String> path = shell.getPath();
        for(String dir : path){
            System.out.print("/"+dir);
        }
        if(path.isEmpty()){
            System.out.print("/");
        }
        System.out.print ("\n");
    }
}
