import org.apache.hc.core5.util.Asserts;
import org.example.core.driver.WebDriverFactory;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.untils.WaitUtils.waitUntilElementISClickable;

public class TestRunner {
    public static void main(String[] args) {
//        WebDriver driver = WebDriverFactory.getDriver();
//        driver.get(ConfigProvider.getBASE_URL());
//
//
//       WebElement elTitle = driver.findElement(By.xpath("//a[@href='/ct/2133/']"));
//        waitUntilElementISVisible(driver, elTitle);
//        waitUntilElementISClickable(driver, elTitle);
//        elTitle.click();
//
//        WebElement elHeadPhonesCta = driver.findElement(By.xpath("//div[@class='base']//a[@href='/ct/1004/]"));
//
//
//        driver.quit();


        WebDriver driver = WebDriverFactory.getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        waitUntilElementISClickable(driver, homePage.getElPadCta());
        homePage.getElPadCta().click();


        driver.quit();

    }
}
