package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.pages.CrateAccountPage;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest{
    @Test(dataProvider = "dataForCreateAccountTest", dataProviderClass = DataProviderMethods.class)
    public void canCreateAccount(String firstname, String lastname, String email, String password, String confirmPassword){
        CrateAccountPage createAccountPage = new CrateAccountPage(driver);
        createAccountPage.open();

        createAccountPage.setFirstName(firstname);
        createAccountPage.setLastName(lastname);
        createAccountPage.setEmail(email);
        createAccountPage.setPassword(password);
        createAccountPage.setConfirmPassword(confirmPassword);
        createAccountPage.getElCreateAccountCta().click();

        createAccountPage.checkAllErrorFields(firstname, lastname , email,password,confirmPassword);
    }
}


//dddfGFD_$43