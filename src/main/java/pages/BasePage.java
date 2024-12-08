package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement getElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void typeIn(By locator, String text){
        WebElement element = getElement(locator);
        //element.clear();
        element.sendKeys(text);
    }

    protected void clickOnElement(By categories){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(categories)).click();
        }catch (ElementClickInterceptedException cl){
            cl.printStackTrace();
            wait.until(ExpectedConditions.presenceOfElementLocated(categories)).click();
        }catch (TimeoutException t){
            getElement(categories).click();
        }catch (Exception e){
            WebElement element = getElement(categories);
            js.executeScript("arguments[0].click();", element);
        }
    }

    protected boolean matchesExpectedText(By locator, String expectedText){
        WebElement element = getElement(locator);
        //Assert.assertEquals(element.getText(), expectedText); ovo nikako
        if (element.getText().trim().equals(expectedText)){
            //log
            return true;
        }else {
            //log error
        }
        return false;
    }




}
