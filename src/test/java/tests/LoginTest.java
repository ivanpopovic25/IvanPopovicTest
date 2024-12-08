package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataproviders.DataProviders;
import pages.LoginPage;


import java.util.List;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void loginSetup() {
        loginPage = new LoginPage(driver);
    }



    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviders.class)
    public void invalidLoginTest(String username, String password){
        loginPage.goToLoginForm()
                .loginUser(username, password);
       
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

 


}
