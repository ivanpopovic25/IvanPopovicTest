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

    // @Test
    // public void loginUserTest(){
    //     loginPage.goToLoginPage();
    //     loginPage.loginUser("1", "1");
    //     Assert.assertTrue(false);
    // }

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviders.class)
    public void invalidLoginTest(String username, String password){
        loginPage.goToLoginForm()
                .loginUser(username, password);
        //Utils.waitForSeconds(2);
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    // @Test
    // public void invalidLoginFromJsonTest(){
    //     List<LoginUser> list = Utils.getDataFromJson();
    //     for (int i = 0; i < list.size(); i++) {
    //          loginPage.goToLoginForm()
    //                  .loginUser(list.get(i).getUsername(), list.get(i).getPassword());
    //         Assert.assertTrue(loginPage.isErrorMessagePresent());
    //     }
    // }

    // @Test(groups = {"smoke", "regression"})
    // @Parameters({"username", "password"})
    // public void loginUserFromTestNgXmlTest(String username, String password){
    //     loginPage.goToLoginForm()
    //             .loginUser(username, password);
    //     Assert.assertTrue(false);
    // }


}
