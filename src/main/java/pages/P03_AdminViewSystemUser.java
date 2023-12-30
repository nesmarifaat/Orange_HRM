package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class P03_AdminViewSystemUser {

    WebDriver driver;

    public P03_AdminViewSystemUser(WebDriver driver) {

        this.driver = driver;
    }

    private final By username = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");

    public P03_AdminViewSystemUser filluasername(String username) {
        driver.findElement(this.username).sendKeys(username);
        return this;
    }

    //TODO: Open user role drop down

    private final By userrole = By.xpath("//div[contains(text(),'-- Select --')]");

    public P03_AdminViewSystemUser openuserroledropdown() {
        driver.findElement(this.userrole).click();
        return this;
    }

    //TODO: choose random user role
    private final By selectrole = By.xpath("(//div[@class=\"oxd-select-text-input\"][" + 1 + "])");

    public P03_AdminViewSystemUser selectrole() {

        driver.findElement(this.selectrole).sendKeys(Keys.ARROW_UP);
        driver.findElement(this.selectrole).sendKeys(Keys.ENTER);
        return this;
    }

    //TODO: fill Employee Name

    private final By empname = By.xpath("//input[@placeholder=\"Type for hints...\"]");

    public P03_AdminViewSystemUser fillemployeename(String empname) throws InterruptedException {
        driver.findElement(this.empname).sendKeys(empname);
        Thread.sleep(4000);
        driver.findElement(this.empname).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.empname).sendKeys(Keys.ENTER);
        return this;
    }

    //TODO: Select Status

    private final By status = By.xpath("//label[contains(., 'Status')]//following::div[1]//div[@class='oxd-select-text-input']");

    public P03_AdminViewSystemUser selectstatus() {

        driver.findElement(this.status).click();
        driver.findElement(this.status).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.status).sendKeys(Keys.ENTER);
        return this;
    }

    //TODO: Click on search button

    private final By searchbutton = By.xpath("//button[@type=\"submit\"]");

    public P03_AdminViewSystemUser clickonsearchbutton() {
        driver.findElement(this.searchbutton).click();
        return this;
    }

    //TODO: Assert search result

    private final By trashicon = By.xpath("//i[@class=\"oxd-icon bi-trash\"]");

    public Boolean checksearchrecord() {

        return driver.findElement(this.trashicon).isDisplayed();
    }

    //***************************************************************************************

    //TODO: Click on Add Button
    private final By addbutton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");

    public P03_AdminViewSystemUser clickonaddbutton() {

        driver.findElement(this.addbutton).click();
        return this;
    }


    private final By newuserrole = By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");

    public P03_AdminViewSystemUser selectnewrole() {
        driver.findElement(this.newuserrole).click();
        driver.findElement(this.newuserrole).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.newuserrole).sendKeys(Keys.ENTER);

        return this;
    }

    private final By newstatus = By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]");

    public P03_AdminViewSystemUser selectnewstatus() {
        driver.findElement(this.newstatus).click();
        driver.findElement(this.newstatus).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.newstatus).sendKeys(Keys.ENTER);
        return this;
    }


    private final By newempname = By.xpath("//input[@placeholder=\"Type for hints...\"]");

    public P03_AdminViewSystemUser chooseemployeename(String newempname) throws InterruptedException {
        driver.findElement(this.newempname).sendKeys(newempname);
        Thread.sleep(3000);
        driver.findElement(this.newempname).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.newempname).sendKeys(Keys.ENTER);

        return this;
    }

    private final By newusername = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");

    public P03_AdminViewSystemUser fillusername(String newusername) {
        driver.findElement(this.newusername).sendKeys(newusername);
        return this;
    }

    private final By password = By.xpath("(//input[@type=\"password\"])[1]");

    public P03_AdminViewSystemUser fillpassword(String password) {
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    private final By confirmpassword = By.xpath("(//input[@type=\"password\"])[2]");

    public P03_AdminViewSystemUser fillconfirmpassword(String confirmpassword) {
        driver.findElement(this.confirmpassword).sendKeys(confirmpassword);
        return this;
    }

    private final By savebutton = By.xpath("//button[@type=\"submit\"]");

    public P03_AdminViewSystemUser clickonsavebutton() {
        driver.findElement(this.savebutton).click();
        return this;
    }


}
