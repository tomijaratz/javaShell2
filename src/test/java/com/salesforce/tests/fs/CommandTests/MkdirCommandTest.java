package com.salesforce.tests.fs.CommandTests;

import Commands.LsCommand;
import Commands.MkdirCommand;
import org.junit.Assert;
import org.junit.Test;

public class MkdirCommandTest extends BaseCommandTest {
    private MkdirCommand command;

    private LsCommand lsCommand = new LsCommand();

    @Test
    public void mkdirShouldCreateDirectoryCorrectly(){
        command = new MkdirCommand("dir1");
        command.execute(shell);
        lsCommand.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/dir1" + "\n", result);
    }

    @Test
    public void mkdirMustShowDirectoryAlreadyExistsMessageWhenWeWantToAddAnAlreadyExistingDirectory(){
        command = new MkdirCommand("dir1");
        command.execute(shell);
        command.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("Directory already exists" + "\n", result);
    }
}
