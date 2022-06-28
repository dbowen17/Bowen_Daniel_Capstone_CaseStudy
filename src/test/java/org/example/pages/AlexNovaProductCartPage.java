package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlexNovaProductCartPage {

    private WebDriver driver;


    public AlexNovaProductCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSize() {

        WebElement sizeSelectButton = driver.findElement(By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/div/form/div[1]/div[1]/div[1]/div[2]/div[4]/label"));
        sizeSelectButton.click();

    }

    public void selectColor() {
        WebElement colorButton = driver.findElement(By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/div/form/div[1]/div[1]/div[2]/div[2]/div[4]/label"));
        colorButton.click();

    }

    public void selectAddTo() {
        WebElement addToButton = driver.findElement(By.xpath("/html/body/div[3]/div[1]/section/div/div[3]/div/form/div[4]/input"));
        addToButton.click();

    }

    public void displayCart() {
        WebElement cartDisplay = driver.findElement(By.xpath("/html/body/div[2]/section/header/div[1]/div/div[2]/div[2]/a"));
        cartDisplay.click();
    }

    public String getCartInfo() {
        return driver.findElement(By.className("cart-count-number")).getText();
    }

    public void pageRefresh() {
        WebElement refreshPage = driver.findElement(By.id("navigation-home"));
        refreshPage.click();
    }

    public void inputQuantity() {
        WebElement addQuantity = driver.findElement(By.id("ispbxii_1"));
        addQuantity.clear();
        addQuantity.sendKeys("2");
        selectAddTo();
    }

    public void removeQuantity() {
        WebElement deleteQuantity = driver.findElement(By.name("updates[]"));
        deleteQuantity.clear();
        deleteQuantity.sendKeys("0");
        WebElement updateQuantity = driver.findElement(By.name("update"));
        updateQuantity.click();
    }

    public boolean productPrice() {
        WebElement priceDiscount = driver.findElement(By.xpath("//*[@id=\"shopify-section-product\"]/section/div/div[3]/div/p/span[1]"));
        priceDiscount.isDisplayed();
        WebElement priceOriginal = driver.findElement(By.xpath("//*[@id=\"shopify-section-product\"]/section/div/div[3]/div/p/span[2]"));
        priceOriginal.isDisplayed();
        return true;
    }


}
