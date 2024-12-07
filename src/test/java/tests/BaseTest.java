package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void initialSetup(){
        driver = DriverManager.setDriver("chrome");
        driver.get("https://practicesoftwaretesting.com/");
    }

}
