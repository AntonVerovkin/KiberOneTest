package testNg;

import org.example.core.data.DataProviderMethods;
import org.example.pages.LumaHomePage;
import org.testng.annotations.Test;

public class SearchingTest extends  BaseTest{
    @Test(dataProvider = "dataForSearchingClothes", dataProviderClass = DataProviderMethods.class)
    public void canSearchItem(String forSearching){
        LumaHomePage lumaHomePage = new LumaHomePage(driver);

        lumaHomePage.open();

        lumaHomePage.searchElSearchInput(forSearching);
    }
}
