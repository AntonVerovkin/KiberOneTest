package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class LumaHomePage extends BasePage{
    @Getter
    private final String CREATE_ACCOUNT_URL = "https://magento2-demo.magebit.com/";

    @FindBy(xpath = "//input[@id='search']")
    private WebElement elSearchInput;
    @FindBy(xpath = "//li[@class='item search']//strong")
    private WebElement elSearch2;
    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    private WebElement elSearch;



    public LumaHomePage(WebDriver driver) {
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
        waitUntilElementISVisible(driver, elSearchInput);
    }

    public void searchElSearchInput(String forSearching) {
        waitUntilElementISVisible(driver, elSearchInput);
        elSearchInput.sendKeys(forSearching, Keys.ENTER);

        WebElement searchResult = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
        String resultText = searchResult.getText();
        Assert.assertTrue(resultText.contains(forSearching), "Результат поиска не содержит 'yoga'");

        WebElement searchResult2 = driver.findElement(By.xpath("//li[@class='item search']//strong"));
        String resultText2 = searchResult2.getText();
        Assert.assertTrue(resultText2.contains(forSearching), "Результат поиска не содержит 'yoga'");

    }
}
