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

import java.util.List;
import java.util.Locale;

import javax.xml.xpath.XPath;
 

public class BasketPage extends BasePage{

    LoginPage loginPage;

  
    public By product1 = By.xpath("//h5[contains(text(),'Combination Pliers')]");
    private By product1Plus = By.cssSelector("button[data-test='increase-quantity']");
    private By productAddToCart = By.cssSelector("button[data-test='add-to-cart']");
    private By home = By.cssSelector("a[data-test='nav-home']");
    public By product2 = By.xpath("//h5[contains(text(),'Bolt Cutters')]");
    private By productCount = By.id("lblCartCount");
    private By proceed = By.cssSelector("button[data-test='proceed-1']");
    private By proceed2 = By.cssSelector("button[data-test='proceed-2']");
    private By state = By.cssSelector("input[data-test='state']");
    private By postcode = By.cssSelector("input[data-test='postcode']");
    private By proceed3 = By.cssSelector("button[data-test='proceed-3']");
    private By paymentType = By.cssSelector("select[data-test='payment-method']");
    private By finish = By.cssSelector("button[data-test='finish']");
   
    

    public BasketPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void addToBasket() throws Exception{
        Thread.sleep(5000);
        clickOnElement(product1);
        clickOnElement(product1Plus);
        clickOnElement(productAddToCart);
        Thread.sleep(3500);
        clickOnElement(home);
        Thread.sleep(1500);
        clickOnElement(product2);
        Thread.sleep(1000);
        clickOnElement(productAddToCart);
        Thread.sleep(10000);
        clickOnElement(productCount);
        Thread.sleep(1000);
        clickOnElement(proceed);
        Thread.sleep(2000);
        loginPage.loginUser("admin@practicesoftwaretesting.com", "welcome01");
        clickOnElement(proceed2);
        Thread.sleep(1000);
        typeIn(state, "xxx");
        typeIn(postcode, "12345");
        clickOnElement(proceed3);
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("payment-method")));
        select.selectByIndex(2);
        Thread.sleep(2000);
        clickOnElement(finish);
    }

    public int getProductSum() {
        WebElement e = driver.findElement(productCount);
        int basketValue = Integer.parseInt(e.getText());
        System.out.println("prodsum" + basketValue);
        return basketValue;
        
        
    }

    public int getProduct1() throws Exception{
        Thread.sleep(5000);
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

    
        
            WebElement e = rows.get(0).findElements(By.xpath(".//td[@class='col-md-2 align-middle']//input[@data-test='product-quantity']")).get(0);
        int basketValue = Integer.parseInt(e.getAttribute("value"));
        System.out.println("prod1" + basketValue);
        return basketValue;
    }

    public int getProduct2() throws Exception{
        Thread.sleep(5000);
        List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));

    
        
            WebElement e = rows.get(1).findElements(By.xpath(".//td[@class='col-md-2 align-middle']//input[@data-test='product-quantity']")).get(0);
        int basketValue = Integer.parseInt(e.getAttribute("value"));
        System.out.println("prod2" + basketValue);
        return basketValue;
    }

    public int getProduct1and2() throws Exception{
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

    
        
            WebElement e1 = rows.get(0).findElements(By.xpath(".//td[@class='col-md-2 align-middle']//input[@data-test='product-quantity']")).get(0);
            WebElement e2 = rows.get(1).findElements(By.xpath(".//td[@class='col-md-2 align-middle']//input[@data-test='product-quantity']")).get(0);
        int basketValue1 = Integer.parseInt(e1.getAttribute("value"));
        int basketValue2 = Integer.parseInt(e2.getAttribute("value"));
        System.out.println("prod1" + basketValue1);
        System.out.println("prod2" + basketValue2);
        return basketValue1 + basketValue2;
    }

    public String getPaymentMessage(){
        WebElement paymentMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/form/div[2]/div"));
        String message = paymentMessage.getText();
        return message;
    }

}