package com.salesforce.tests.fs.CommandTests;

import Commands.CdCommand;
import Commands.MkdirCommand;
import Commands.PwdCommand;
import org.junit.Assert;
import org.junit.Test;

public class CdCommandTest extends BaseCommandTest {

    private CdCommand command;

    private PwdCommand pwdCommand = new PwdCommand();

    private MkdirCommand mkdirCommand;

    @Test
    public void cdShouldStayInRootWhenCalledToGoUpOneLevel() {
        command = new CdCommand("cd ..");
        pwdCommand.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/"+"\n", result);
    }

    @Test
    public void cdShouldBeAbleToGoToAnyChildrenDirectory() {
        command = new CdCommand("dir1");
        mkdirCommand = new MkdirCommand("dir1");
        mkdirCommand.execute(shell);

        command.execute(shell);
        pwdCommand.execute(shell);

        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/dir1" + "\n", result);
    }

    @Test
    public void cdShouldBeAbleToReachParentFromDir1() {
        command = new CdCommand("dir1");
        mkdirCommand = new MkdirCommand("dir1");
        mkdirCommand.execute(shell);

        command.execute(shell);
        command = new CdCommand("..");
        command.execute(shell);
        pwdCommand.execute(shell);

        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/" + "\n", result);
    }

    @Test
    public void cdShouldBeAbleToGoDownManyLevels() {
        command = new CdCommand("dir1");
        mkdirCommand = new MkdirCommand("dir1");
        mkdirCommand.execute(shell);
        command.execute(shell);

        command = new CdCommand("..");
        mkdirCommand = new MkdirCommand("dir2");
        mkdirCommand.execute(shell);
        command.execute(shell);

        command = new CdCommand("dir1/dir2");
        command.execute(shell);

        pwdCommand.execute(shell);

        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/dir1/dir2" + "\n", result);
    }

    @Test
    public void cdCanNotGoToANotExistingDirectory() {
        command = new CdCommand("dir2");
        mkdirCommand = new MkdirCommand("dir1");
        mkdirCommand.execute(shell);

        command.execute(shell);

        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("Directory does not exists" + "\n", result);
    }
}


