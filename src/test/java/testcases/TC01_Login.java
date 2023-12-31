package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_Login;
import pages.P02_Home;
import retrytest.Retry;
import utilities.Utility;

import java.io.IOException;

import static pages.PageBase.waitForPageLoad;
import static utilities.Utility.*;

@Feature("Login Feature")
@Epic("Login Epic")
public class TC01_Login extends TestBase {


    String Username = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "Username");
    String UsernameII = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "UsernameII");
    String PasswordII = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "UsernameII");
    String Password = Utility.getExcelData(0, 0, "Sheet1");

    public TC01_Login() throws IOException, ParseException {
    }

    @Description("Login with valid username and password")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1, description = "Login with valid username and password", retryAnalyzer = Retry.class)
    public void loginwithvalidData_P() {
        // TODO: wait DOM page load
        waitForPageLoad(driver);

        new P01_Login(driver).fillusername(Username).fillpassword(Password).clickonloginbutton();
        ;
        captureScreenshot(driver, "P_Login");
        Assert.assertTrue(new P02_Home(driver).checkvisabilityofdashboard());


    }

    @Description(" Login with valid username and Invalid password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, description = "Check login with valid Username and invalid password")
    public void loginwithvalidusernameandinvalidpass_N() throws InterruptedException {

        // TODO: wait DOM page load
        waitForPageLoad(driver);

        new P01_Login(driver).fillusername(Username).fillpassword(PasswordII).clickonloginbutton();
        captureScreenshot(driver, "N_login with invalid password");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P01_Login(driver).checkinvalidcredentialvisability());
        softAssert.assertAll();
    }

    @Description(" Login with valid password and Invalid username")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, description = "Check Login Functionality with invalid username and valid password")
    public void loginwithinvaliduserandvalidpadd_N() throws InterruptedException {
        new P01_Login(driver).fillusername(UsernameII).fillpassword(Password).clickonloginbutton();
        captureScreenshot(driver, "N_Login with invalid User name");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P01_Login(driver).checkinvalidcredentialvisability());
        softAssert.assertAll();

    }

    @Description(" Login with invalid password and Invalid username")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, description = "Check login functionality with invalid username and password")
    public void loginwithinvaliduserandpass_N() throws InterruptedException {
        new P01_Login(driver).fillusername(UsernameII).fillpassword(PasswordII).clickonloginbutton();
        captureScreenshot(driver, "N_Login with invalid User name and password");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P01_Login(driver).checkinvalidcredentialvisability());
        softAssert.assertAll();

    }


}
