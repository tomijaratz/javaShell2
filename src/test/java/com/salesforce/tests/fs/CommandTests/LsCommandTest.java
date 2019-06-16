package com.salesforce.tests.fs.CommandTests;

import Commands.LsCommand;
import org.junit.Assert;
import org.junit.Test;

public class LsCommandTest extends BaseCommandTest {

    private LsCommand command = new LsCommand();

    @Test
    public void lsShouldReturnEmptyIfTheDirectoryIsEmpty(){
        command.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("", result);
    }

    @Test
    public void lsShouldShowFilesAndDirectoriesWhenTheyExist(){
        shell.makeDirectory("dir1");
        shell.addFileToCurrentDirectory("file.txt");

        command.execute(shell);
        String result = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals("/dir1" + "\n" + "file.txt" + "\n", result);
    }
}
