package com.pastebin.PastebinTest;

import com.Fixtures.BaseTest;
import com.pastebin.PastebinTest.pageobjects.CreateNewPastePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewPasteTest extends BaseTest {
    @Test(alwaysRun = true,
            priority =1,
            description ="This test create a New Paste with the appropriate options")
    public void successCreateNewPaste(){
        String pasteName="helloweb";
        String heading=new CreateNewPastePage(driver)
                .openPage()
                .inputNewPaste("Hello from WebDriver")
                .choicePasteExpiration("10 Minutes")
                .inputPasteName(pasteName)
                .getHeadingNewPaste();
        Assert.assertEquals(heading,pasteName);
    }
}
