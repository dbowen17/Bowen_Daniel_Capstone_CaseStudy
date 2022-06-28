package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlexNovaSearchPage {

    private WebDriver driver;

    By searchHeader = By.xpath("/html/body/div[3]/div[2]/div[3]/div[5]/div[1]/div[2]/h2/span");
    By noResults = By.xpath("/html/body/div[3]/div[2]/div[3]/div[5]/ul/li[1]");

    public  AlexNovaSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean findSearchHeader(){
        driver.findElement(searchHeader).isDisplayed();
        return true;
    }
    public boolean findNoResults(){
        driver.findElement(noResults).isDisplayed();
        return true;
    }
}
