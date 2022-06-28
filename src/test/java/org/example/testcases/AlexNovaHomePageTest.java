package org.example.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import org.example.pages.AlexNovaLoginPage;
import org.example.pages.AlexNovaRegistrationPage;
import org.example.pages.AlexNovaSearchPage;
import org.example.pages.AlexNovaHomePage;
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

public class AlexNovaHomePageTest {
    WebDriver driver;
    AlexNovaLoginPage loginPage;
    AlexNovaHomePage homePage;
    AlexNovaSearchPage searchPage;
    AlexNovaRegistrationPage registrationPage;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    public static List<WebElement> pics = new ArrayList<>();

    @BeforeSuite
    public void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/HomePageTestReport.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Daniel.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Daniel Bowen");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Alex and Nova");
        htmlReporter.config().setReportName("Home Page Test Report");
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
    public void SearchProductTest() {
        //need in every test S said so!!!!!!!
        test = extent.createTest(" Search Product ", "Test Passed");
        //very important to pass down the driver
        homePage = new AlexNovaHomePage(driver);
        homePage.enterProduct();
        homePage.startSearch();
        searchPage = new AlexNovaSearchPage(driver);
        Assert.assertTrue(searchPage.findSearchHeader());

    }
    @Test(priority = 2)
    public void SearchNoProductTest() throws InterruptedException {
        test = extent.createTest(" Search No Product", "Test Passed");
        //very important to pass down the driver
        homePage = new AlexNovaHomePage(driver);
        homePage.blankProduct();
        Thread.sleep(3000);
        homePage.startSearch();
        searchPage = new AlexNovaSearchPage(driver);
        Assert.assertTrue(searchPage.findNoResults());

    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
