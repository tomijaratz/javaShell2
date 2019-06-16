package com.salesforce.tests.fs.CommandTests;

import Commands.LsCommand;
import Commands.TouchCommand;
import org.junit.Assert;
import org.junit.Test;

public class TouchCommandTest extends BaseCommandTest {

    private TouchCommand command;

    private LsCommand lsCommand = new LsCommand();

    @Test
    public void touchShouldCreateFileCorrectly(){
        command = new TouchCommand("file.txt");
        command.execute(shell);
        lsCommand.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("file.txt" + "\n", result);
    }

    @Test
    public void touchMustShowFileAlreadyExistsMessageWhenWeWantToAddAnAlreadyExistingFile(){
        command = new TouchCommand("file.txt");
        command.execute(shell);
        command.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("File already exists" + "\n", result);
    }
}
