package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlexNovaCheckoutPage {
    private WebDriver driver;





    public AlexNovaCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterDiscount(){
        WebElement addDiscount = driver.findElement(By.id("checkout_reduction_code"));
        addDiscount.sendKeys("BABYFREE");
       WebElement applyDiscount = driver.findElement(By.xpath("/html/body/div[1]/div/aside/div[2]/div[1]/div/div[2]/form[2]/div/div/div/button"));
       applyDiscount.click();
    }
    public void enterShippingAddressFields(){
        WebElement shippingAddress = driver.findElement(By.id("checkout_shipping_address_address1"));
        shippingAddress.sendKeys("0701 Graduation Street");
        WebElement shippingCity = driver.findElement(By.id("checkout_shipping_address_city"));
        shippingCity.sendKeys("Denver");
        WebElement shippingZip = driver.findElement(By.id("checkout_shipping_address_zip"));
        shippingZip.sendKeys("80237");
        WebElement shippingPhone = driver.findElement(By.id("checkout_shipping_address_phone"));
        shippingPhone.sendKeys("320-111-1111");

    }
    public void contShipping(){
        WebElement continueShipping = driver.findElement(By.id("continue_button"));
        continueShipping.click();
    }
    public void contPayment(){
        WebElement continuePayment = driver.findElement(By.xpath("/html/body/div/div/div/main/div[1]/form/div[2]/button"));
        continuePayment.click();
    }
    public void verifyPaymentMethods(){
        WebElement creditPayment = driver.findElement(By.id("checkout_payment_gateway_14059208761"));
       creditPayment.isDisplayed();
        WebElement shopPayPayment = driver.findElement(By.id("checkout_payment_gateway_66130411573"));
        shopPayPayment.click();
        WebElement payPalPayment = driver.findElement(By.id("checkout_payment_gateway_14059175993"));
        payPalPayment.click();
    }
    public boolean fieldErrors(){
        WebElement addressError = driver.findElement(By.id("error-for-address"));
        addressError.isDisplayed();
        WebElement  cityError= driver.findElement(By.id("error-for-city"));
        cityError.isDisplayed();
        WebElement zipError= driver.findElement(By.id("error-for-zip"));
        zipError.isDisplayed();

        return false;
    }
    public void creditCardFrame(){
        WebElement iframe = driver.findElement(By.className("card-fields-iframe"));
        driver.switchTo().frame(iframe);

    }
    public void insertCard() {
        WebElement cardNumber = driver.findElement(By.xpath("//*[@id=\"number\"]\n"));
        cardNumber.sendKeys("3698");
        cardNumber.sendKeys("5214");
        cardNumber.sendKeys("7698");
        cardNumber.sendKeys("74");
    }

    public void creditNameFrame(){
        WebElement nframe = driver.findElement(By.xpath("//*[@title=\"Field container for: Name on card\"]"));
        driver.switchTo().frame(nframe);
    }
    public void insertName(){
            WebElement cardName = driver.findElement(By.name("name"));
            cardName.sendKeys("John Fink");
    }
    public void creditExpiryFrame(){
        WebElement eframe = driver.findElement(By.xpath("//*[@title=\"Field container for: Expiration date (MM / YY)\"]"));
        driver.switchTo().frame(eframe);
    }

    public void insertExpiry(){
            WebElement cardExpiration = driver.findElement(By.name("expiry"));
            cardExpiration.sendKeys("06");
            cardExpiration.sendKeys("05");
    }
    public void creditSecurityFrame(){
        WebElement sframe = driver.findElement(By.xpath("//*[@title=\"Field container for: Security code\"]"));
        driver.switchTo().frame(sframe);
    }
        public void insertSecurity(){
        WebElement cardSecurityCode = driver.findElement(By.name("verification_value"));
        cardSecurityCode.sendKeys("222");

    }
    public void sameShipping(){
        WebElement billingSame = driver.findElement(By.id("checkout_different_billing_address_false"));
        billingSame.isDisplayed();
    }
    public void payNow(){
        WebElement payButton = driver.findElement(By.id("continue_button"));
       payButton.click();
    }
    public boolean payError(){
        WebElement paymentErrorMessage = driver.findElement(By.className("notice__text"));
        paymentErrorMessage.isDisplayed();
        return true;
    }
}
