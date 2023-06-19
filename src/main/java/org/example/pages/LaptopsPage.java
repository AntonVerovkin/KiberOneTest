package org.example.pages;

import lombok.Getter;
import org.example.untils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class LaptopsPage extends BasePage{
        private  final String LAPTOP_PAGE_URL = "https://pn.com.ua/ct/1003/";

    @Getter
    @FindBy(xpath = "//ul[@class='breadcrumb']//descendant::li[4]/h1/span")
    private WebElement elLaptopDeliCta;

    @Getter
    @FindBy(xpath = "//ul[@class='breadcrumb']//descendant::li[4]/h1/span")
    private WebElement elLastTitleBreadcrumb;

    @Getter
    @FindBy(xpath = "//div[@class='catalog-block-head']//a")
    private List<WebElement> elsItemTitleList;

    @Getter
    @FindBy(xpath = "//a[@data-id='282']")
    private WebElement elDell;

    public LaptopsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public void ensureOpened() {
       waitUntilElementISVisible(driver, elLastTitleBreadcrumb);


    }
    @Override
    public void open() {
        super.driver.get(LAPTOP_PAGE_URL);
        ensureOpened();
    }



}