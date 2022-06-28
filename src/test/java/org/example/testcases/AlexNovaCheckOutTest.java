package org.example.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AlexNovaCheckOutTest {
    WebDriver driver;
    AlexNovaCheckoutPage checkoutPage;
    AlexNovaLoginPage loginPage;
    AlexNovaProductCartPage productPage;
    AlexNovaHomePage homePage;
    AlexNovaRegistrationPage registrationPage;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/CheckOutTest.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Daniel.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Daniel Bowen");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Alex and Nova");
        htmlReporter.config().setReportName("Check Out Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @BeforeTest
    public void launchBrowser(){

        driver = SelectBrowser.StartBrowser("Chrome");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Very important for wait content appears
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://alexandnova.com/");

    }

    @Test(priority = 1)
    public void CheckoutGiftCard() {
        test = extent.createTest(" Login User Page", "Test Passed");
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        productPage.displayCart();
        homePage = new AlexNovaHomePage(driver);
        homePage.clickCheckout();
        checkoutPage = new AlexNovaCheckoutPage(driver);
        checkoutPage.enterDiscount();

    }
    @Test(priority = 2)
    public void CheckoutPaymentMode() throws InterruptedException {
        test = extent.createTest(" Login User Page", "Test Passed");
        //very important to pass down the driver
        homePage = new AlexNovaHomePage(driver);
        homePage.clickAccount();
        loginPage = new AlexNovaLoginPage(driver);
        loginPage.signIn();
        loginPage.clickLogIn();
        Thread.sleep(30000);
        loginPage.goHome();
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        productPage.displayCart();
        homePage = new AlexNovaHomePage(driver);
        homePage.clickCheckout();
        checkoutPage = new AlexNovaCheckoutPage(driver);
        checkoutPage.enterShippingAddressFields();
        checkoutPage.contShipping();
        Thread.sleep(4000);
        checkoutPage.contPayment();
        Thread.sleep(4000);
        checkoutPage.verifyPaymentMethods();

    }
    @Test(priority = 3)
    public void CheckoutFieldValidation() throws InterruptedException {
        test = extent.createTest(" Login User Page", "Test Passed");
        //very important to pass down the driver
        homePage = new AlexNovaHomePage(driver);
        homePage.clickAccount();
        loginPage = new AlexNovaLoginPage(driver);
        loginPage.signIn();
        loginPage.clickLogIn();
        Thread.sleep(30000);
        loginPage.goHome();
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        productPage.displayCart();
        homePage = new AlexNovaHomePage(driver);
        homePage.clickCheckout();
        checkoutPage = new AlexNovaCheckoutPage(driver);
        checkoutPage.contShipping();
        Assert.assertTrue(checkoutPage.fieldErrors());

    }
    @Test(priority = 4)
    public void CheckoutProduct() throws InterruptedException {
        test = extent.createTest(" Login User Page", "Test Passed");
        //very important to pass down the driver
        homePage = new AlexNovaHomePage(driver);
        homePage.clickAccount();
        loginPage = new AlexNovaLoginPage(driver);
        loginPage.signIn();
        loginPage.clickLogIn();
        Thread.sleep(30000);
        loginPage.goHome();
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        productPage.displayCart();
        homePage = new AlexNovaHomePage(driver);
        homePage.clickCheckout();
        checkoutPage = new AlexNovaCheckoutPage(driver);
        checkoutPage.enterShippingAddressFields();
        checkoutPage.contShipping();
        Thread.sleep(4000);
        checkoutPage.contPayment();
        checkoutPage.creditCardFrame();
        checkoutPage.insertCard();
        driver.switchTo().parentFrame();
        checkoutPage.creditNameFrame();
        checkoutPage.insertName();
        driver.switchTo().parentFrame();
        checkoutPage.creditExpiryFrame();
        checkoutPage.insertExpiry();
        driver.switchTo().parentFrame();
        checkoutPage.creditSecurityFrame();
        checkoutPage.insertSecurity();
        driver.switchTo().parentFrame();

        Thread.sleep(3000);
        checkoutPage.payNow();
        Assert.assertTrue(checkoutPage.payError());
    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
