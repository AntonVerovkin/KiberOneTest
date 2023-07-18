package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.core.CommandPageMatthods.emailPatternMatches;
import static org.example.core.CommandPageMatthods.passwordPatternMatches;
import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class CrateAccountPage extends BasePage{
    @Getter
    private final String CREATE_ACCOUNT_URL = "https://magento2-demo.magebit.com/customer/account/create/";

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement elFirstNameInput;

    @FindBy(xpath = "//div[@id='firstname-error']")
    private WebElement elFirstnameError;
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement elLastNameInput;
    @FindBy(xpath = "//div[@id='lastname-error']")
    private WebElement elLastnameError;
    @FindBy(xpath = "//input[@id='is_subscribed']")
    private WebElement elIsSubscribedCheckBox;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement elEmailInput;

    @FindBy(xpath = "//div[@id='email_address-error']")
    private WebElement elEmailError;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement elPasswordInput;
    @FindBy(xpath = "//div[@id='password-error']")
    private WebElement elPasswordError;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement elPasswordConfirmationInput;
    @FindBy(xpath = "//div[@id='password-confirmation-error']")
    private WebElement elPasswordConfirmationError;
    @Getter
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement elCreateAccountCta;

    public CrateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    @Override
    public void open() {
        super.driver.get(CREATE_ACCOUNT_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementISVisible(driver, elFirstNameInput);
    }

    public void setFirstName(String firstName) {
        waitUntilElementISVisible(driver, elFirstNameInput);
        elFirstNameInput.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        waitUntilElementISVisible(driver, elLastNameInput);
        elLastNameInput.sendKeys(lastName);
    }
    public void setEmail(String email) {
        waitUntilElementISVisible(driver, elEmailInput);
        elEmailInput.sendKeys(email);
    }
    public void setPassword(String password) {
        waitUntilElementISVisible(driver, elPasswordInput);
        elPasswordInput.sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword) {
        waitUntilElementISVisible(driver, elPasswordConfirmationInput);
        elPasswordConfirmationInput.sendKeys(confirmPassword);
    }

    public void checkFirstNameError(String firstName){
        if (firstName.isEmpty()){
            waitUntilElementISVisible(driver, elFirstnameError);
            Assert.assertEquals(elFirstnameError.getText(),"This is a required field.", "expected firstname error message doesn't match actual message ");
        }
    }

    public void checkLastNameError(String lastName){
        if (lastName.isEmpty()){
            waitUntilElementISVisible(driver, elLastnameError);
            Assert.assertEquals(elLastnameError.getText(),"This is a required field.", "expected lastName error message doesn't match actual message ");
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



    public void checkPasswordError(String password) {
        if (password.isEmpty()) {
            waitUntilElementISVisible(driver, elPasswordError);
            Assert.assertEquals(elPasswordError.getText(), "This is a required field.",
                    "expected password error message doesn't match actual message");
        } else if (password.length() < 8) {
            waitUntilElementISVisible(driver, elPasswordError);
            Assert.assertEquals(elPasswordError.getText(), "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.",
                    "expected password error message doesn't match actual message");
        } else if (!passwordPatternMatches(password)) {
            waitUntilElementISVisible(driver, elPasswordError);
            Assert.assertEquals(elPasswordError.getText(), "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.",
                    "expected password error message doesn't match actual message");
        }
    }




    public void checkConfirmPasswordError(String password, String confirmPassword) {
        if (confirmPassword.isEmpty()) {
            waitUntilElementISVisible(driver, elPasswordConfirmationError);
            Assert.assertEquals(elPasswordConfirmationError.getText(), "This is a required field.",
                    "expected password error message doesn't match actual message");
        } else if (!confirmPassword.equals(password)) {
            waitUntilElementISVisible(driver, elPasswordConfirmationError);
            Assert.assertEquals(elPasswordConfirmationError.getText(), "Please enter the same value again.",
                    "expected password error message doesn't match actual message");
        }
    }



    public void checkAllErrorFields(String firstName,String lastName,String email, String password,String ConfirmPassword ){
        checkFirstNameError(firstName);
        checkLastNameError(lastName);
        checkEmailError(email);
        checkPasswordError(password);
        checkConfirmPasswordError(password, ConfirmPassword);

    }



}
