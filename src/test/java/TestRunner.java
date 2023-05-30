import org.example.core.driver.WebDriverFactory;
import org.example.untils.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRunner {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.getBASE_URL());
        WebElement elTitle = driver.findElement(By.xpath("//a[@href='/ct/2133/']"));

        //WebElement elHeadPhonesCta = driver.findElement(By.xpath("//div[@class='base']//a[@href='/ct/1004/]"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(elTitle));
        elTitle.click();
        driver.quit();
    }
}
