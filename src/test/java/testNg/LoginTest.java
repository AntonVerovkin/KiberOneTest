package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.listeners.retryListeners;
import org.example.pages.CrateAccountPage;
import org.example.pages.LumaSingingPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test(dataProvider = "dataForSinging", dataProviderClass = DataProviderMethods.class, retryAnalyzer = retryListeners.class)
    public void canLogin(  String password, String email){
        LumaSingingPage lumaSingingPage = new LumaSingingPage(driver);
        lumaSingingPage.open();

        lumaSingingPage.setEmail(email);
        lumaSingingPage.setPassword(password);
        lumaSingingPage.getElSingingButton().click();
        lumaSingingPage.allErrorMethods(password, email);

    }
}

