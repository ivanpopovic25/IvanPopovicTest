package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeMethod
    public void registerSetup(){
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    //nacin 1
    @Test(description = "Register user happy path; Expected result: user is successfully registered")
    public void registerUserTest(){
        registerPage.goToRegisterPage();
        registerPage.registerUser();
        loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());
        Assert.assertTrue(registerPage.isUserRegistered(), "User is not registered");
    }

    //nacin 2
    @Test(description = "Register user happy path; Expected result: user is successfully registered")
    public void registerUserTest2(){
        registerPage.goToRegisterPage();
        registerPage.registerUser();
        loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());

        String expectedText = "My account";
        Assert.assertEquals(registerPage.actualText(), expectedText, "User is not registered");
    }

    //nacin 3
    @Test(description = "Register user happy path; Expected result: user is successfully registered")
    public void registerUserTest3(){
        registerPage.goToRegisterPage();
        registerPage.registerUser();
        loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());

        registerPage.verifyUserIsRegistered();
    }

}
