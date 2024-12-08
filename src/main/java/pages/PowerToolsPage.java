package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import javax.xml.xpath.XPath;

public class PowerToolsPage extends BasePage {

    private By categories = By.cssSelector("a[data-test='nav-categories']");
    private By powerTools = By.cssSelector("a[data-test='nav-power-tools']");
    // WebElement drill = driver.findElement(By.cssSelector("input.icheck"));
    // label[text()='Drill']/preceding-sibling::input
    public By drill = By.xpath("//label[contains(text(), 'Drill')]/preceding-sibling::input[@type='checkbox']");

    private int productCountBefore;
    private int productCountAfter;

    


    public PowerToolsPage(WebDriver driver) {
        super(driver);

    }

    public void categories() throws Exception{
        Thread.sleep(2000);
        clickOnElement(categories);
        clickOnElement(powerTools);
        Thread.sleep(1000);
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='container']//a[@class='card']"));

            // Get the count of product elements
        productCountBefore = products.size();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement drillCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='checkbox']//label[contains(text(), 'Drill')]//preceding-sibling::input")
            ));
                drillCheckbox.click();
            
        Thread.sleep(1000);
        List<WebElement> productsAfter = driver.findElements(By.xpath("//div[@class='container']//a[@class='card']"));
        productCountAfter = productsAfter.size();
    }

    public int getCountBefore() {
        return productCountBefore;
    }

    public int getCountAfter() {
        return productCountAfter;
    }

    
}






