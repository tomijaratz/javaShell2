import Commands.Command;
import Commands.Factory.CommandFactory;
import Shell.Shell;
import Shell.Directory;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        //the root directory
        Directory currentDirectory = new Directory(null, "root");

        //this object represents the shell and we are going to execute commands on it
        Shell shell = new Shell(currentDirectory);

        Scanner scanner = new Scanner(System.in);

        //parse and execute
        while (scanner.hasNext()) {
            String[] userInput = scanner.nextLine().split(" ");

            //here we get the right command handler
            Command command = CommandFactory.getCommandForInput(userInput);

            command.execute(shell);

        }
    }
}
