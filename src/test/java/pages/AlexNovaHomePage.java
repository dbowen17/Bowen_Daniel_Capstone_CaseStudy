package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlexNovaHomePage {
    WebDriver driver;

   By searchField = By.xpath("/html/body/div[2]/section/header/div[2]/div[4]/form/input[1]");
    By accountButton = By.xpath("/html/body/div[2]/section/header/div[1]/div/div[2]/div[1]/a");

    By searchButton = By.xpath("/html/body/div[2]/section/header/div[2]/div[4]/form/input[2]");

    By cartButton = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/div[2]/a/span[1]");

    By checkoutButton = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[1]/div/div[2]/a");

    By secondDotButton = By.xpath("/html/body/div[3]/div[1]/section/ol/li[2]");

    public AlexNovaHomePage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterProduct(){
       driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys("baby shoes");
    }

    public void blankProduct(){
        driver.findElement(searchField).click();
    }

    public void startSearch(){
        driver.findElement(searchButton).click();
    }

    public void clickAccount(){
        driver.findElement(accountButton).click();

    }
    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }
    public void secondDot(){
        driver.findElement(secondDotButton).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/section/div/div/article[2]/figure/a/img")).click();
    }

    public String getHomeCartInfo(){
        return driver.findElement(By.className("cart-count-number")).getText();
    }
}
