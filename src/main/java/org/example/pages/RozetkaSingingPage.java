package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class RozetkaSingingPage extends BasePage {
    private  final String ROZETKA_PAGE_URL = "https://rozetka.com.ua/";

    @Getter
    @FindBy(xpath = "//rz-user//button[@class='header__button ng-star-inserted']")
    private WebElement elLoginCta;

    @Getter
    @FindBy(xpath = "//button[@class='auth-modal__register-link button button--link ng-star-inserted']")
    private WebElement elRegistrationCta;

    @Getter
    @FindBy(xpath = "//input[@id='registerUserSurname']")
    private WebElement elRegistrationUserSurnameCta;

    @Getter
    @FindBy(xpath = "//input[@id='registerUserName']")
    private WebElement elRegistrationUserNameCta;

    @Getter
    @FindBy(xpath = "//input[@id='registerUserEmail']")
    private WebElement elRegistrationUserEmailCta;

    @Getter
    @FindBy(xpath = "//input[@id='registerUserPassword']")
    private WebElement elRegisterUserPasswordCta;

    public RozetkaSingingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void ensureOpened() {
        waitUntilElementISVisible(driver, elLoginCta);


    }
    @Override
    public void open() {
        super.driver.get(ROZETKA_PAGE_URL);
        ensureOpened();
    }

    public void setFirstName(String firstName){
        waitUntilElementISVisible(driver, elRegistrationUserNameCta);
        elRegistrationUserNameCta.sendKeys(firstName);
    }

    public void setFirstSurname(String firstSurname){
        waitUntilElementISVisible(driver, elRegistrationUserSurnameCta);
        elRegistrationUserSurnameCta.sendKeys(firstSurname);
    }

    public void setFirstEmail(String firstEmail){
        waitUntilElementISVisible(driver, elRegistrationUserEmailCta);
        elRegistrationUserEmailCta.sendKeys(firstEmail);
    }

    public void setFirstPassword(String firstPassword){
        waitUntilElementISVisible(driver, elRegisterUserPasswordCta);
        elRegisterUserPasswordCta.sendKeys(firstPassword);
    }
}

