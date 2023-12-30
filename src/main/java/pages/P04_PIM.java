package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P04_PIM {
    WebDriver driver;

    public P04_PIM(WebDriver driver) {
        this.driver = driver;
    }

    private final By empname = By.xpath("(//input[@placeholder=\"Type for hints...\"])[1]");

    public P04_PIM selectempname(String empname) throws InterruptedException {
        driver.findElement(this.empname).sendKeys(empname);
        Thread.sleep(2000);
        driver.findElement(this.empname).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.empname).sendKeys(Keys.ENTER);
        return this;
    }

    private final By employeeID = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");

    public P04_PIM fillemployeeid(String employeeID) {
        driver.findElement(this.employeeID).sendKeys(employeeID);
        return this;
    }

    private final By employmentstatus = By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");

    public P04_PIM selectemploymentstatus() throws InterruptedException {
        driver.findElement(this.employmentstatus).click();
        Thread.sleep(2000);
        driver.findElement(this.employmentstatus).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.employmentstatus).sendKeys(Keys.ENTER);
        return this;
    }

    private final By inculde = By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]");

    public P04_PIM selectincludeemployee() throws InterruptedException {
        driver.findElement(this.inculde).click();
        Thread.sleep(2000);
        driver.findElement(this.inculde).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.inculde).sendKeys(Keys.ENTER);
        return this;
    }

    private final By searchbutton = By.xpath("//button[@type=\"submit\"]");

    public P04_PIM clickonsearchbutton() {
        driver.findElement(this.searchbutton).click();
        return this;
    }

    private final By trashicon = By.xpath("//i[@class=\"oxd-icon bi-trash\"]");

    public Boolean checkiftrashiconvisible() {

        return driver.findElement(this.trashicon).isDisplayed();
    }

    private final By addbutton = By.xpath("(//button[@type=\"button\"])[4]");

    public P04_PIM clickonaddbutton() {
        driver.findElement(this.addbutton).click();
        return this;
    }

    //TODO: Fill Employee Information to be added

    private final By employeefirstname = By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-firstname\"]");

    public P04_PIM fillemployeefirstname(String employeeinfo) {
        driver.findElement(this.employeefirstname).sendKeys(employeeinfo);

        return this;
    }

    private final By middlename = By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-middlename\"]");

    public P04_PIM fillmiddlename(String middlename) {
        driver.findElement(this.middlename).sendKeys(middlename);
        return this;
    }

    private final By lastname = By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-lastname\"]");

    public P04_PIM filllastname(String lastname) {
        driver.findElement(this.lastname).sendKeys(lastname);
        return this;
    }

}