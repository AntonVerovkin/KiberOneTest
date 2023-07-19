package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.example.core.CommandPageMatthods.emailPatternMatches;
import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class LumaSingingPage extends BasePage{
    @Getter
    private final String LOGIN_PAGE_URL = "https://magento2-demo.magebit.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvMi1kZW1vLm1hZ2ViaXQuY29tLw%2C%2C/";

    @FindBy(xpath = "//input[@id='email']")
    private WebElement elEmailInput;
    @FindBy(xpath = "//div[@for='email']")
    private WebElement elEmailError;
    @FindBy(xpath = "//div[@class='control']//input[@id='pass'][@autocomplete='off'][@title='Password']")
    private WebElement elPasswordInput;
    @FindBy(xpath = "//div[@for='pass']")
    private WebElement elPasswordError;
    @Getter
    @FindBy(xpath = "//button[@class='action login primary']")
    private WebElement elSingingButton;
    

    public LumaSingingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    @Override
    public void open() {
        super.driver.get(LOGIN_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementISVisible(driver, elEmailInput);
    }

    public void setEmail(String email) {
        waitUntilElementISVisible(driver, elEmailInput);
        elEmailInput.clear();
        elEmailInput.sendKeys(email);
    }


    public void setPassword(String password) {
        waitUntilElementISVisible(driver, elPasswordInput);
        elPasswordInput.clear();
        elPasswordInput.sendKeys(password);
    }

    public void checkPasswordError(String password){
        if (password.isEmpty()){
            waitUntilElementISVisible(driver, elPasswordError);
            Assert.assertEquals(elPasswordError.getText(),"This is a required field.", "expected firstname error message doesn't match actual message ");
        }
    }
    public void checkEmailError(String email){
        if (!emailPatternMatches(email)){
            waitUntilElementISVisible(driver, elEmailError);
            Assert.assertEquals(elEmailError.getText(), "Please enter a valid email address (Ex: johndoe@domain.com).", "expected error message doesnt match actual value ");
        } else if(email.isEmpty()){
            waitUntilElementISVisible(driver, elEmailError);
            Assert.assertEquals(elEmailError.getText(),

                    "This is a required field.", "expected email error message doesn't match actual message ");
        }
    }

    public void allSetMethods(String password, String email){


    }

    public void allErrorMethods(String password, String email){

        checkEmailError(email);
        checkPasswordError(password);
    }


}
