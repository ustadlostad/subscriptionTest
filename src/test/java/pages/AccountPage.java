package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.Random;

public class AccountPage {
    WebDriver driver;
    Wait wait;

    Random rand = new Random();
    int random = rand.nextInt(5000);

    private String accountPageUrl = "https://connect-au.beinsports.com/en/account/register?r=%2Fen%2Fcard%2Fbasket&f=Subscription";
    private String currentUrl;
    private String nameFieldXpath = "//input[@name='FirstName']";
    private String surnameFieldXpath = "//input[@name='LastName']";
    private String emailFieldXpath = "//input[@name='EmailOrPhone']";
    private String passwordFieldXpath = "//input[@name='Password']";
    private String creataAccountButtonXpath = "//input[@type='submit']";

    private String username = "digiTest";
    private String surname = "digiTest";
    private String email = "sovad" + random + "@40as.com";
    private String password = "123412agGA1234";


    public AccountPage(WebDriver driver, Wait wait){
        this.driver=driver;
        this.wait= wait;



    }

    public void checkAccountPageUrl(){
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(accountPageUrl,currentUrl);
    }

    public void enterUsername(){
        driver.findElement(By.xpath(nameFieldXpath)).sendKeys(username);
    }

    public void enterSurname(){
        driver.findElement(By.xpath(surnameFieldXpath)).sendKeys(surname);
    }

    public void enterEmail(){
        driver.findElement(By.xpath(emailFieldXpath)).sendKeys(email);
    }

    public void enterPassword(){
        driver.findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
    }

    public void createAccount(){
        driver.findElement(By.xpath(creataAccountButtonXpath)).click();
    }
}
