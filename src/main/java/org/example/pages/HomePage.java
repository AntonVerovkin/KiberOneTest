package org.example.pages;

import lombok.Getter;
import org.example.untils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@href='/ct/2133/']")
    private WebElement elTitle;

    @Getter
    @FindBy(xpath = "//div[@class='base']//a[@href='/ct/1004/']")
    private WebElement elPadCta;
    @Getter
    @FindBy(xpath = "//div[@class='pc-block']//a[@title='Ноутбуки']")
    private WebElement elLaptopCta;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.getBASE_URL());
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementISVisible(super.driver, elTitle);
    }
}
