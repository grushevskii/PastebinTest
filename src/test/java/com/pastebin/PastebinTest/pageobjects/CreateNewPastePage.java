package com.pastebin.PastebinTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewPastePage {
    WebDriver driver;
    protected static String url="https://pastebin.com";

    @FindBy(id="paste_code")
    private WebElement newPasteText;

    @FindBy(name="paste_expire_date")
    private WebElement pasteExpiration;

    @FindBy(name="paste_name")
    private WebElement pasteName;

    @FindBy(name="paste_format")
    private WebElement syntaxHighlighting;

    public CreateNewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CreateNewPastePage openPage (){
        driver.get(url);
        return this;
    }

    public CreateNewPastePage inputNewPaste(String text){
        newPasteText.sendKeys(text);
        return this;
    }

    public CreateNewPastePage choiceSyntaxHighlighting(String syntax){
        Select select = new Select(syntaxHighlighting);
        select.selectByVisibleText(syntax);
        return this;
    }

    public CreateNewPastePage choicePasteExpiration(String expiration){
        Select select = new Select(pasteExpiration);
        select.selectByVisibleText(expiration);
        return this;
    }
    public NewPastePage inputPasteName(String text){
        pasteName.sendKeys(text);
        pasteName.submit();
        return new NewPastePage(driver);
    }
}
