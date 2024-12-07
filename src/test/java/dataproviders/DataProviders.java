package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {


    @DataProvider(name = "loginDataProvider", parallel = false)
    public Object[][] loginDataProvider(){
        return new Object[][]{
                {"username", ""},
                {"", "password"},
                {"", ""},
                {"admin@practicesoftwaretesting.com", "welcome01"},
        };
    }


}
