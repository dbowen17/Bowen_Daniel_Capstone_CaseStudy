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

public class AlexNovaProductToCartTest {

    WebDriver driver;
    AlexNovaLoginPage loginPage;
    AlexNovaHomePage homePage;
    AlexNovaSearchPage searchPage;
    AlexNovaRegistrationPage registrationPage;
    AlexNovaProductCartPage productPage;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ProductCartTestReport.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Daniel.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Daniel Bowen");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Alex and Nova");
        htmlReporter.config().setReportName("Product Cart Test Report");
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
    public void ProductPrice(){
    test = extent.createTest("Product Price", "Test Passed");
    homePage = new AlexNovaHomePage(driver);
    homePage.secondDot();
    productPage = new AlexNovaProductCartPage(driver);
    Assert.assertTrue(productPage.productPrice());
    }
    @Test(priority = 2)
    public void ProductInCart() throws InterruptedException {
        test = extent.createTest(" Product In Cart", "Test Passed");
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        Thread.sleep(4000);
        Assert.assertEquals("1", productPage.getCartInfo());
    }

    @Test(priority = 3)
    public void ProductCartRefresh() throws InterruptedException {
        test = extent.createTest(" Product Cart Refresh", "Test Passed");
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        Thread.sleep(4000);
        productPage.pageRefresh();
        homePage = new AlexNovaHomePage(driver);
        Assert.assertEquals("1", homePage.getHomeCartInfo());

    }
    @Test(priority = 4)
    public void ProductCartIncreaseQuantity() throws InterruptedException {
        test = extent.createTest(" Product Increase Quantity", "Test Passed");
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        Thread.sleep(4000);
        productPage.inputQuantity();
        Thread.sleep(4000);
        Assert.assertEquals("3", productPage.getCartInfo());

    }
    @Test(priority = 5)
    public void ProductQuantityVerification() throws InterruptedException {
        test = extent.createTest(" Product Quantity Verification", "Test Passed");
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        Thread.sleep(4000);
        productPage.displayCart();
    }
    @Test(priority = 6)
    public void ProductCartItemRemoval() throws InterruptedException {
        test = extent.createTest(" Product Cart Item Removal", "Test Passed");
        homePage = new AlexNovaHomePage(driver);
        homePage.secondDot();
        productPage = new AlexNovaProductCartPage(driver);
        productPage.selectSize();
        productPage.selectColor();
        productPage.selectAddTo();
        Thread.sleep(4000);
        productPage.displayCart();
        Thread.sleep(4000);
        productPage.removeQuantity();
        Assert.assertEquals("0", productPage.getCartInfo());

    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
       }
}
