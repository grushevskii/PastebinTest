package com.pastebin.PastebinTest;

import com.Fixtures.BaseTest;
import com.pastebin.PastebinTest.pageobjects.CreateNewPastePage;
import com.pastebin.PastebinTest.pageobjects.NewPastePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerificationTest extends BaseTest {
    String newPaste="git config --global user.name  \"New Sheriff in Town\"" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
            "git push origin master --force";
    String pasteName="how to gain dominance among developers";
    String syntax="Bash";

    @Test(alwaysRun = true,
            priority =1,
            description ="This test create a New Paste and verification title")
    public void createNewPasteAndVerificationTitle(){
        String title=new CreateNewPastePage(driver)
                .openPage()
                .inputNewPaste(newPaste)
                .choiceSyntaxHighlighting(syntax)
                .choicePasteExpiration("10 Minutes")
                .inputPasteName(pasteName)
                .getHeadingNewPaste();
        Assert.assertEquals(title,pasteName);
        String syntaxText=new NewPastePage(driver).getSyntaxText();
        Assert.assertEquals(syntaxText,syntax);
        String newPasteText=new NewPastePage(driver).getNewPasteText();
        Assert.assertEquals(newPasteText,newPaste);
    }

    @Test(alwaysRun = true,
            priority =2,
            description ="This test create a New Paste and verification syntax")
    public void createNewPasteAndVerificationSyntax(){
        String syntaxText=new NewPastePage(driver).getSyntaxText();
        Assert.assertEquals(syntaxText,syntax);
    }

    @Test(alwaysRun = true,
            priority =3,
            description ="This test create a New Paste and verification New Paste Text")
    public void createNewPasteAndVerificationNewPasteText(){
        String newPasteText=new NewPastePage(driver).getNewPasteText();
        Assert.assertEquals(newPasteText,newPaste);
    }
}
