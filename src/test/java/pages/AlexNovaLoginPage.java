package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlexNovaLoginPage {
    private WebDriver driver;

    By logInButton = By.xpath("//*[@id=\"customer_login\"]/div[3]/input");
    By registerButton = (By.xpath("/html/body/div[3]/div[2]/div[3]/a"));

    public AlexNovaLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogIn() {
        driver.findElement(logInButton).click();
    }

    public void clickRegister() {

        driver.findElement(registerButton).click();
    }

    public void signIn() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/form/div[1]/input")).sendKeys("testpass71@ps71.com");
        driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[1]/form/div[2]/input")).sendKeys("P@ssword");
    }
    public void signIn2(){
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/form/div[1]/input")).sendKeys("testpass7132@ps71.com");
        driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[1]/form/div[2]/input")).sendKeys("P@ssnone");
    }
    public void goHome(){
        driver.findElement(By.xpath("/html/body/div[2]/section/header/div[2]/div[3]/nav/ul/li[1]/a")).click();
    }

    public boolean checkWelcome() {
        driver.findElement(By.xpath("/html/body/div[3]/h1"));

        return true;
    }

    public boolean errorSorry() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/form/p"));
        return true;
    }

}
