package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class VideocardPage extends BasePage {
    private final String VIDEO_CARD_PAGE_URL = "https://pn.com.ua/ct/1047/";

    @Getter
    @FindBy(xpath = "//a[contains(text(), 'Lenovo')]")
    private WebElement elLenovo;

    @Getter
    @FindBy(xpath = "//ul[@class='breadcrumb']//descendant::li[4]/h1/span")
    private WebElement elLastTitleBreadcrumb;

    @Getter
    @FindBy(xpath = "//div[@class='catalog-block-head']//a")
    private List<WebElement> elsItemTitleList;

    public VideocardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void ensureOpened() {
        waitUntilElementISVisible(driver, elLastTitleBreadcrumb);
    }

    @Override
    public void open() {
        super.driver.get(VIDEO_CARD_PAGE_URL);
        ensureOpened();
    }
}
