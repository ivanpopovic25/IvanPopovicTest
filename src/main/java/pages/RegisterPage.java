package pages;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Locale;

public class RegisterPage extends BasePage{


    private By firstNameFiled = By.id("first_name");
    private By lastNameFiled = By.id("last_name");
    private By dobFiled = By.id("dob");
    private By addressFiled = By.id("address");
    private By postCodeFiled = By.id("postcode");
    private By cityFiled = By.id("city");
    private By stateFiled = By.id("state");
    private By countryFiled = By.id("country");
    private By phoneFiled = By.id("phone");
    private By emailFiled = By.id("email");
    private By passwordFiled = By.cssSelector("input[data-test='password']");

    private By registerButton = By.cssSelector(".btnSubmit");

    private By signInLink = By.cssSelector("a[data-test='nav-sign-in']");
    private By registerPageLink = By.cssSelector("a[data-test='register-link']");

    private By myAccountPageTitle = By.cssSelector("h1[data-test='page-title']");
    private By profileText = By.cssSelector("a[data-test='nav-profile']");

    Faker faker = new Faker(new Locale("en-US"));

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private String username;
    private String password;


    public void registerUser(){
        username = "ivan@gmail.com";
        password = "Ivan.1111";
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        typeIn(firstNameFiled, faker.name().firstName());
        typeIn(lastNameFiled, faker.name().lastName());
        typeIn(dobFiled, "12121999");
        typeIn(addressFiled, faker.address().fullAddress());
        typeIn(postCodeFiled, faker.number().digits(6));
        typeIn(cityFiled, faker.address().city());
        typeIn(stateFiled, faker.address().state());
        selectCountry();
        typeIn(phoneFiled, faker.number().digits(10));
        typeIn(emailFiled, username);
        typeIn(passwordFiled, password);
        clickOnElement(registerButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToRegisterPage(){
        clickOnElement(signInLink);
        clickOnElement(registerPageLink);
    }

    private void selectCountry(){
        WebElement element = getElement(countryFiled);
        Select select = new Select(element);
        select.selectByValue("RS");
        //select.selectByVisibleText("Algeria");
        //select.selectByIndex(50);
    }

    public boolean isUserRegistered(){
        return matchesExpectedText(myAccountPageTitle, "My account") &&
                matchesExpectedText(profileText, "Profile");
    }

    public String actualText(){
        return getElement(myAccountPageTitle).getText();
    }

    public void verifyUserIsRegistered(){
        Assert.assertEquals(getElement(myAccountPageTitle).getText().trim(), "My account");
        Assert.assertEquals(getElement(profileText).getText().trim(), "Profile");
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
