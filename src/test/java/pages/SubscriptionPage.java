package pages;

import io.cucumber.java.cy_gb.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;


public class SubscriptionPage {

    WebDriver driver;
    Wait wait;

    private String subPackageName =  "Monthly Plan with Two Week Free Trial";
    private String getSubPackagePriceXpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[2]";
    public String subPackagePrice;
    private String subscribeButtonXpath = "//a[@data-btn-index='0' and @data-text=\"SUBSCRIBE\"]";
    private String accountPageHeaderXpath = "//h1[contains(text(),'CREATE ACCOUNT')]";

    public SubscriptionPage(WebDriver driver, Wait wait){
        this.driver=driver;
        this.wait= wait;
    }

    public void checkPackageName(){
        driver.getPageSource().contains(subPackageName);
    }

    public void checkPackagePrice(){
        subPackagePrice = driver.findElement(By.xpath(getSubPackagePriceXpath)).getText();
        Assert.assertEquals("AU$19.99",subPackagePrice);
    }

    public void clickPackageSubscribe(){
        driver.findElement(By.xpath(subscribeButtonXpath)).click();
    }

    public void checkAccountPageNavigation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accountPageHeaderXpath)));

    }



}
