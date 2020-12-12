package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class OrderPage {

    WebDriver driver;
    Wait wait;
    Actions action;
    Select select;

    private String charge;
    private String chargeXpath = "/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/small[1]";
    private String nameFieldXpath = "//input[@id='Ecom_Payment_Card_Name']";
    private String cardNumberXpath = "//input[@id='Ecom_Payment_Card_Number']";
    private String dateSelectionXpath = "//select[@id='Ecom_Payment_Card_ExpDate_Month']";
    private String yearSelectionXpath = "//select[@id='Ecom_Payment_Card_ExpDate_Year']";
    private String cardCodeXpath = "//input[@id='Ecom_Payment_Card_Verification']";
    private String paymentButtonXpath = "//input[@id='submit3']";
    private String alert;

    public OrderPage(WebDriver driver, Wait wait, Actions action, Select select){
        this.driver=driver;
        this.wait= wait;
        this.action= action;
        this.select = select;

    }

    public void checkOrderPage(){
        wait.until(ExpectedConditions.titleIs("Payment confirmation"));
    }

    public void checkCharge(){
        charge = driver.findElement(By.xpath(chargeXpath)).getText();
        Assert.assertEquals(charge,"1.00 AUD");
    }

    public void enterName(){
        driver.findElement(By.xpath(nameFieldXpath)).sendKeys("Eyup Sabri Tuncer");
    }

    public void enterCardNumber(){
        driver.findElement(By.xpath(cardNumberXpath)).sendKeys("1111111111111111");
    }

    public void selectDate(){
        Select date = new Select(driver.findElement(By.xpath(dateSelectionXpath)));
        date.selectByIndex(11);
    }

    public void selectYear(){
        Select year = new Select(driver.findElement(By.xpath(yearSelectionXpath)));
        year.selectByIndex(3);
    }

    public void enterVerifCode(){
        driver.findElement(By.xpath(cardCodeXpath)).sendKeys("123");
    }

    public void confirmPaymet(){
        driver.findElement(By.xpath(paymentButtonXpath)).click();
    }

    public void confirmAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert().getText();
        Assert.assertEquals(alert,"This field is not valid.: 'Card number'");
        driver.switchTo().alert().accept();

    }

}
