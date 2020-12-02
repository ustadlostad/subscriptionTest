package stepDefinitions;

import org.junit.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestSteps {

    public TestSteps(){
        System.getProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        landingPage = new LandingPage(driver,wait);
        subscriptionPage = new SubscriptionPage(driver,wait);
        accountPage = new AccountPage(driver,wait);
        paymentMethodPage = new PaymentMethodPage(driver, wait, action);
        orderPage = new OrderPage(driver, wait, action, select);
    }

    Wait wait;
    WebDriver driver;
    Actions action;
    Select select;
    AccountPage accountPage;
    LandingPage landingPage ;
    OrderPage orderPage;
    PaymentMethodPage paymentMethodPage;
    SubscriptionPage subscriptionPage;


    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        driver.navigate().to("https://connect-au.beinsports.com/en");
    }

    @And("user click subscription button")
    public void user_click_subscription_button() {
        landingPage.clickSubButton();
    }

    @Then("user is navigated to the subs")
    public void user_is_navigated_to_the_subs() {
        landingPage.checkSubPageUrl();
    }

    @Given("user is on sub page")
    public void user_is_on_sub_page() throws Exception {
        landingPage.checkSubPageUrl();
    }

    @Then("page contains two week free trial")
    public void page_contains_two_week_free_trial() {
        subscriptionPage.checkPackageName();
    }

    @Then("validate package price")
    public void validate_package_price() {
        subscriptionPage.checkPackagePrice();
    }

    @And("user clicks sub button")
    public void user_clicks_sub_button() {
        subscriptionPage.clickPackageSubscribe();
    }

    @Then("user is navigated to Account Page")
    public void user_is_navigated_to_account_page() {
        subscriptionPage.checkAccountPageNavigation();
    }

    @Given("user is on Account Page")
    public void user_is_on_account_page() {
        accountPage.checkAccountPageUrl();
    }

    @When("user enters name surname email password")
    public void user_enters_name_surname_email_password() {
        accountPage.enterUsername();
        accountPage.enterSurname();
        accountPage.enterEmail();
        accountPage.enterPassword();
    }

    @When("clicks create account button")
    public void clicks_create_account_button() {
        accountPage.createAccount();
    }

    @Then("user is navigated to payment method page")
    public void user_is_navigated_to_payment_method_page() {
        paymentMethodPage.checkPaymentMethodPage();
    }

    @Given("user is on payment method page")
    public void user_is_on_payment_method_page() {
        paymentMethodPage.verifyPage();
    }

    @Given("user checks Terms and Conditions Button")
    public void user_checks_terms_and_conditions_button() {
        paymentMethodPage.checkTermsButton();
    }
    @Given("pay now button is clickable")
    public void pay_know_button_is_clickable() {
        paymentMethodPage.verifyPayNowButtonClickable();
    }
    @Given("user clicks pay now button")
    public void user_clicks_pay_now_button() {
        paymentMethodPage.clickPayNowButton();
    }

    @Then("user is navigated to order page")
    public void user_is_navigated_to_order_page() {
        orderPage.checkOrderPage();
    }

    @Given("user is on order page")
    public void user_is_on_order_page() {
        orderPage.checkOrderPage();
    }
    @When("charge is 1.00")
    public void check_package_price() {
        orderPage.checkCharge();
    }

    @And("user enters name")
    public void user_enters_name() {
        orderPage.enterName();
    }

    @And("user enters card number")
    public void user_enters_card_number() {
        orderPage.enterCardNumber();
    }

    @And("user enters expiry date")
    public void user_enters_expiry_date() {
        orderPage.selectDate();
        orderPage.selectYear();
    }

    @And("user enters verf code")
    public void user_enters_verf_code() {
        orderPage.enterVerifCode();
    }

    @And("user clicks confirm button")
    public void user_clicks_confirm_button() {
        orderPage.confirmPaymet();
    }

    @Then("page gives error")
    public void page_gives_error() {
        orderPage.confirmAlert();
    }

    @Then("close browser")
    public void tearDown(){
        driver.quit();
    }
}
