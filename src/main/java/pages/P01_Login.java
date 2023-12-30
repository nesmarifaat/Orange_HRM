package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.*;

public class P01_Login {

    //TODO: Define Webdriver
    WebDriver driver;

    //TODO: Define Constractor

    public P01_Login(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Fill Username

    private final By username = By.xpath("//input[@name=\"username\"]");

    public P01_Login fillusername(String username) {
        // call wait
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.username));
        driver.findElement(this.username).sendKeys(username);
        return this;
    }

    //TODO: Password
    private final By password = By.xpath("//input[@type=\"password\"]");

    public P01_Login fillpassword(String password) {
        try {
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    //TODO: Click Login Button

    private final By loginbutton = By.xpath("//button[@type=\"submit\"]");

    public P01_Login clickonloginbutton() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginbutton));
            fluentWaitHandling(driver, "//button[@type=\"submit\"]");
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happen is " + ex.getMessage());
        }
        driver.findElement(this.loginbutton).click();
        return this;
    }

    //TODO: Login Assertion

    private final By userdropdownname = By.xpath("//p[@class='oxd-userdropdown-name']");

    public Boolean assertlogin() {
        return driver.findElement(this.userdropdownname).getText().equals("Shai madhrchod");
    }

    private final By invalidcredential = By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]");

    public Boolean checkinvalidcredentialvisability() {

        return driver.findElement(this.invalidcredential).isDisplayed();
    }


}
