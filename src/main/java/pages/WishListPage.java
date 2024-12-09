package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import javax.xml.xpath.XPath;

public class WishListPage extends BasePage {

    LoginPage loginPage;

    String productText;

    private By home = By.cssSelector("a[data-test='nav-home']");
    public By product1 = By.xpath("//h5[contains(text(),'Combination Pliers')]");
    private By productAddToFav = By.cssSelector("button[data-test='add-to-favorites']");
    private By menu = By.id("menu");
    private By myFavorites = By.cssSelector("a[data-test='nav-my-favorites']");
    // public By productFav = By.xpath("//h5[contains(text(),'Combination Pliers')]");
    public By productFav;

    public WishListPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        
    }

    public void addToWishList() throws Exception{
        Thread.sleep(2000);
        clickOnElement(home);
        Thread.sleep(3000);
        WebElement productElement = driver.findElement(product1);
        productText = productElement.getText();
        clickOnElement(product1);
        Thread.sleep(2000);
        clickOnElement(productAddToFav);
        Thread.sleep(7000);
        clickOnElement(menu);
        Thread.sleep(1000);
        clickOnElement(myFavorites);

    }

    public boolean isProductExists(String productName){
        try {
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'" + productName + "')]")));
            System.out.println("Element exists!");
            return true;
        } catch (Exception  e) {
            System.out.println("Element does not exist!");
            return false;
        }
    }

        public String getProductName() {
            
            return productText;
            
        }

    }
    

