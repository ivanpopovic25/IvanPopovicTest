package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BasketPage;
import pages.LoginPage;
import pages.RegisterPage;

public class BasketTest extends BaseTest {

    BasketPage basketPage;

    @BeforeMethod
    public void basketSetup(){
        basketPage = new BasketPage(driver);
    }

    //nacin 1
    @Test(description = "Add product to basket")
    public void addToBasketTest() throws Exception{
        basketPage.addToBasket();
        Assert.assertEquals(basketPage.getProductSum(), basketPage.getProduct1and2());
        Assert.assertEquals(basketPage.getPaymentMessage(), "Payment was successful");
    }
}