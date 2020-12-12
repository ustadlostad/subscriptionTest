package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class LandingPage {

    WebDriver driver;
    Wait wait;

    private String subsCriptionButtonXpath = "//a[@class='header-subscribe bc-subscribe visible-md visible-lg menu-subscribe desktop-subscribe']";
    private String subPageUrl = "https://connect-au.beinsports.com/en/subscribe";
    private String currentUrl;
    private String landingPageUrl = "https://connect-au.beinsports.com/en";

    public LandingPage(WebDriver driver, Wait wait){
        this.driver=driver;
        this.wait= wait;
    }

    public void navigateToLandingPage(){
        driver.navigate().to(landingPageUrl);
    }

    public void clickSubButton(){
        driver.findElement(By.xpath(subsCriptionButtonXpath)).click();
    }

    public void checkSubPageUrl(){
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(subPageUrl,currentUrl);
    }


}
