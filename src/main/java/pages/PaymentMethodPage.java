package pages;

import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class PaymentMethodPage {

    WebDriver driver;
    Wait wait;
    Actions action;

    private String paymentMethodPageUrl;
    private String checkBoxXpath = "//body/div[4]/div[1]/form[1]/div[1]/div[4]/div[1]";
    private String checkBoxId = "checkTerms";
    private String paynowButtonXpath = "//body/div[4]/div[1]/form[1]/div[1]/div[6]/input[2]";
    private String itemXpath = "//div[@class='has-item show']";

    public PaymentMethodPage(WebDriver driver, Wait wait, Actions action){
        this.driver=driver;
        this.wait= wait;
        this.action= action;
    }

    public void checkPaymentMethodPage(){
        wait.until(ExpectedConditions.titleIs("Basket"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemXpath)));
    }

    public void verifyPage(){
        driver.getPageSource().contains("PAYMENT METHOD");
    }

    public void checkTermsButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkBoxXpath)));
        WebElement elemet =driver.findElement(By.xpath(checkBoxXpath));
        action.moveToElement(elemet).click().build().perform();
    }

    public void verifyPayNowButtonClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(paynowButtonXpath)));
    }

    public void clickPayNowButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(paynowButtonXpath)));
        WebElement element =driver.findElement(By.xpath(paynowButtonXpath));
        element.isEnabled();
        action.moveToElement(element).click().build().perform();
    }


}
