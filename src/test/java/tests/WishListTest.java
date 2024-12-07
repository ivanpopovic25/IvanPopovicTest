package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataproviders.DataProviders;
import pages.LoginPage;
import pages.WishListPage;

import java.util.List;

public class WishListTest extends BaseTest {

    WishListPage wishListPage;

    @BeforeMethod(alwaysRun = true)
    public void loginSetup() throws Exception{
        LoginPage loginPage = new LoginPage(driver);
        wishListPage = new WishListPage(driver);
        Thread.sleep(2000);
        loginPage.goToLoginPage();
        loginPage.loginUser("customer@practicesoftwaretesting.com", "welcome01");
    }



        @Test(description = "Add product to wishlist")
    public void addToWishList() throws Exception{
        wishListPage.addToWishList();
        Assert.assertTrue(wishListPage.isProductExists(wishListPage.getProductName()));
        
    }
    
}
