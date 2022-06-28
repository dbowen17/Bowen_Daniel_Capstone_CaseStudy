package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlexNovaRegistrationPage {
    private WebDriver driver;

    By registerButton2 = By.xpath("//html/body/div[3]/div[2]/form/div[5]/input");
    By registerBanner = By.xpath("//*[@id=\"keyboard-nav-3\"]/div[1]");


    public AlexNovaRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register() {


        driver.findElement(By.name("customer[first_name]")).sendKeys("Fink");
        driver.findElement(By.name("customer[last_name]")).sendKeys("John");
        driver.findElement(By.name("customer[email]")).sendKeys("testpass71@ps71.com");
        driver.findElement(By.name("customer[password]")).sendKeys("P@ssword");
    }
    public void emailValidate(){
        driver.findElement(By.name("customer[first_name]")).sendKeys("Fink");
        driver.findElement(By.name("customer[last_name]")).sendKeys("John");
        driver.findElement(By.name("customer[email]")).sendKeys("testAtgmail.com");
        driver.findElement(By.name("customer[password]")).sendKeys("P@ssword");
    }
    public void mandatoryField(){
        driver.findElement(By.name("customer[email]")).sendKeys("testAtgmail.com");
        driver.findElement(By.name("customer[password]")).sendKeys("P@ssword");
    }

    public void passwordField(){
        driver.findElement(By.name("customer[first_name]")).sendKeys("Fink");
        driver.findElement(By.name("customer[last_name]")).sendKeys("John");
        driver.findElement(By.name("customer[email]")).sendKeys("testpass32@gmail.com");
        driver.findElement(By.name("customer[password]")).sendKeys("passw");
    }
    public void clickRegisterButton2() {
        driver.findElement(registerButton2).click();
    }

    public boolean verifyFields() {

        return driver.findElement(registerBanner).isDisplayed();


    }
}








