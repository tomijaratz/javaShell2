package com.salesforce.tests.fs.CommandTests;

import Commands.PwdCommand;
import org.junit.Assert;
import org.junit.Test;

public class PwdCommandTest extends BaseCommandTest {

    private PwdCommand command = new PwdCommand();

    @Test
    public void pwdShouldReturnRootDirectoryWhenWeAreThere(){
        command.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/"+"\n", result);
    }

    @Test
    public void pwdShouldReturnChildrenDirectoryWhenWeAreThere(){
        shell.makeDirectory("dir1");
        shell.changeDirectory("dir1");

        command.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/dir1"+"\n", result);
    }
}
