package testNg;

import org.example.pages.HomePage;
import org.example.pages.RozetkaSingingPage;
import org.testng.annotations.Test;

import static org.example.untils.WaitUtils.waitUntilElementISClickable;
import static org.example.untils.WaitUtils.waitUntilElementISVisible;

public class RozetkaRegistrationTest extends BaseTest{
    @Test
    public void checkRozetkaRegestration() {
        RozetkaSingingPage rozetkaSingingPage = new RozetkaSingingPage(driver);
        rozetkaSingingPage.open();
        waitUntilElementISClickable(driver, rozetkaSingingPage.getElLoginCta());

        rozetkaSingingPage.getElLoginCta().click();

        waitUntilElementISClickable(driver, rozetkaSingingPage.getElRegistrationCta());

        rozetkaSingingPage.getElRegistrationCta().click();

        rozetkaSingingPage.setFirstName("абражумайсымба");
        rozetkaSingingPage.setFirstSurname("абражумайсымбавич");
        rozetkaSingingPage.setFirstEmail("ananas@anasas.com");
        rozetkaSingingPage.setFirstPassword("wewT22");



    }
}
