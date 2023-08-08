package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.example.untils.WaitUtils.waitUntilElementISClickable;
import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class LumaCatalogPage extends  BasePage{
    @Getter
    private final String KATALOG_PAGE_URL = "https://magento2-demo.magebit.com/cora-parachute-pant.html";
    @Getter
    @FindBy(xpath = "//div[@data-option-id='175']")
    private WebElement elSizeClick;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-49']")
    private WebElement elColorBlackClick;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-50']")
    private WebElement elColorBlueClick;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-59']")
    private WebElement elColorWhiteClick;

    @FindBy(xpath = "//div[@id='super_attribute[93]-error']")
    private WebElement elColorErrorClick;

    @Getter
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement elCartButton;


    public LumaCatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    @Override
    public void open() {
        super.driver.get(KATALOG_PAGE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementISVisible(driver, elColorBlackClick);
    }

    public void setColor(String color){

        switch (color){

            case "Black":
                waitUntilElementISClickable(driver, elColorBlackClick);
                elColorBlackClick.click();
                break;
            case "Blue":
                waitUntilElementISClickable(driver, elColorBlueClick);
                elColorBlueClick.click();
                break;
            case "White":
                waitUntilElementISClickable(driver, elColorWhiteClick);
                elColorWhiteClick.click();
                break;
        }
    }
    public void CheckErrorMessageError(String color){
        List<WebElement> elColorList = new ArrayList<>();
        elColorList.add(elColorBlackClick);
        elColorList.add(elColorBlueClick);
        elColorList.add(elColorWhiteClick);

        boolean isNoneMatchInList = elColorList.stream().noneMatch(x -> x.getAttribute("data-option-label").equalsIgnoreCase(color));
        if (color.isEmpty()  || isNoneMatchInList){
            waitUntilElementISVisible(driver, elColorErrorClick);
            Assert.assertEquals(elColorErrorClick.getText(), "This is a required field.", "Abeme");
        }
    }
}

















