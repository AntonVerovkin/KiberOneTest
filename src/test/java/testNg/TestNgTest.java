package testNg;

import lombok.extern.log4j.Log4j2;
import org.example.pages.HomePage;
import org.example.pages.LaptopsPage;
import org.example.pages.VideocardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.untils.WaitUtils.waitUntilElementISClickable;
import static org.example.untils.WaitUtils.waitUntilElementISVisible;

@Log4j2
public class TestNgTest extends BaseTest {
    @Test
    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void checkLaptopTitleIsCorrect() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilElementISVisible(driver, homePage.getElLaptopCta());
        if (homePage.getElLaptopCta().getText().equalsIgnoreCase("Ноутбуки2")) {
            log.info("INFO: title works correct: " + homePage.getElLaptopCta().getText());
        } else {
            log.error("Expected title doesn't match actual title: " + homePage.getElLaptopCta().getText());
        }


    }
    @Test
    public void checkIsLaptopHrefCorrect(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        waitUntilElementISClickable(driver, homePage.getElLaptopCta());
        Assert.assertEquals(homePage.getElLaptopCta().getAttribute("href"), "https://pn.com.ua/ct/1003/", "expected href doesn't actual href");
    }

    @Test
    public void checkIsLaptopNameCorrect(){
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.open();
        waitUntilElementISVisible(driver, laptopsPage.getElLastTitleBreadcrumb());
        Assert.assertEquals(laptopsPage.getElLastTitleBreadcrumb().getText(), "Ноутбуки", "expected span doesn't actual span");
    }


    @Test
    public void checkAllLaptopTitlesContainDell() {
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.open();
        waitUntilElementISVisible(driver, laptopsPage.getElDell());

        laptopsPage.getElDell().click();

        for (WebElement item : laptopsPage.getElsItemTitleList()) {
            waitUntilElementISVisible(driver, (WebElement) laptopsPage.getElsItemTitleList());
            String title = item.getText();
            Assert.assertTrue(title.contains("Dell"), "Laptop title does not contain 'Dell': " + title);
        }
    }
    @Test
    public void checkAllLaptopTitlesContainLenovo() {
        VideocardPage videocardPage = new VideocardPage(driver);
        videocardPage.open();




        List<WebElement> itemList = videocardPage.getElsItemTitleList();
        for (int i = 0; i < itemList.size(); i++) {
            videocardPage.open();
            waitUntilElementISClickable(driver, videocardPage.getElLenovo());
            videocardPage.getElLenovo().click();

            WebElement item = itemList.get(i);
            waitUntilElementISClickable(driver, item);
            WebElement itemListI = itemList.get(i);
            Assert.assertTrue(itemList.contains("Lenovo"), "Videocard title does not contain 'Lenovo': " + itemList);


        }
    }


}