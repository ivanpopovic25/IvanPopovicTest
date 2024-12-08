package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataproviders.DataProviders;
import pages.LoginPage;
import pages.PowerToolsPage;
import pages.WishListPage;

import java.util.List;

public class PowerToolsTest extends BaseTest {

    PowerToolsPage powerToolsPage;

    @BeforeMethod(alwaysRun = true)
    public void loginSetup() throws Exception{
        powerToolsPage = new PowerToolsPage(driver);
        Thread.sleep(2000);
        
    }
    
    

@Test(description = "Select drill")
public void categories() throws Exception{
    powerToolsPage.categories();
    Assert.assertTrue(powerToolsPage.getCountBefore() > powerToolsPage.getCountAfter());
    }

}


