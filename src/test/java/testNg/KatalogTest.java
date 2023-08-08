package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.listeners.retryListeners;
import org.example.pages.LumaCatalogPage;
import org.example.pages.LumaSingingPage;
import org.testng.annotations.Test;

public class KatalogTest extends BaseTest{
    @Test(dataProvider = "dataForColor", dataProviderClass = DataProviderMethods.class, retryAnalyzer = retryListeners.class)
    public void canSell(String color){
        LumaCatalogPage lumaCatalogPage = new LumaCatalogPage(driver);
        lumaCatalogPage.open();

        lumaCatalogPage.getElSizeClick().click();
        lumaCatalogPage.setColor(color);
        lumaCatalogPage.getElCartButton().click();
        lumaCatalogPage.CheckErrorMessageError(color);
    }

}
