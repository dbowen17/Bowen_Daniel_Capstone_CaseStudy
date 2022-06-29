package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import pages.AlexNovaLoginPage;
import pages.AlexNovaRegistrationPage;
import pages.AlexNovaHomePage;
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

public class AlexNovaLoginTest {
    WebDriver driver;
    AlexNovaLoginPage loginPage;
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
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/LoginTest.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Daniel.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Daniel Bowen");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle(" AutomationTesting Alex and Nova");
        htmlReporter.config().setReportName("Login Test Report");
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
    public void LogInUserPage() {
        //need in every test S said so!!!!!!!
        test = extent.createTest(" Login User Page", "Test Passed");
        //very important to pass down the driver
        homePage = new AlexNovaHomePage(driver);
        homePage.clickAccount();
        loginPage = new AlexNovaLoginPage(driver);
        loginPage.signIn();
        loginPage.clickLogIn();
        Assert.assertTrue(loginPage.checkWelcome());

    }
    @Test(priority = 2)
    public void EmailLogInVerification(){
        test = extent.createTest(" Login User Email Page", "Test Passed");
        //very important to pass down the driver
        homePage = new AlexNovaHomePage(driver);
        homePage.clickAccount();
        loginPage = new AlexNovaLoginPage(driver);
        loginPage.signIn2();
        loginPage.clickLogIn();
        Assert.assertTrue(loginPage.errorSorry());

    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}

