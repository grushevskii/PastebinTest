package com.pastebin.PastebinTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPastePage {
    WebDriver driver;

    public NewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName="h1")
    private WebElement heading;

    @FindBy(xpath="//*[@href='/archive/bash']")
    private WebElement syntaxText;

    @FindBy(id="paste_code")
    private  WebElement rawPasteData;

    @FindBy(css=".de1")
    private  WebElement newPasteText;

    public String getHeadingNewPaste(){
       return heading.getText();
    }

    public String getSyntaxText(){
        return syntaxText.getText();
    }

    public String getNewPasteText(){
        return newPasteText.getText();
    }
}
