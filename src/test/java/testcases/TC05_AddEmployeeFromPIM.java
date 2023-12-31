package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_Login;
import pages.P02_Home;
import pages.P04_PIM;
import utilities.Utility;

import java.io.IOException;

import static utilities.Utility.captureScreenshot;
import static utilities.Utility.getSingleJsonData;

@Feature("Add New Employee From PIM")
public class TC05_AddEmployeeFromPIM extends TestBase {
    String Username = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "Username");
    String Password = Utility.getExcelData(0, 0, "Sheet1");

    String Employeefirstename = faker.name().firstName();
    String Employeemiddlename = faker.name().firstName();
    String Employeelastname = faker.name().lastName();

    public TC05_AddEmployeeFromPIM() throws IOException, ParseException {
    }

    @Description("Check Add new Employee Functionality from PIM Panel")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Check Add New Employee Functionality From PIM")
    public void addemployeefrompim_P() throws InterruptedException {
        new P01_Login(driver).fillusername(Username).fillpassword(Password).clickonloginbutton();
        new P02_Home(driver).clickonpim();
        new P04_PIM(driver).clickonaddbutton().fillemployeefirstname(Employeefirstename).fillmiddlename(Employeemiddlename).filllastname(Employeelastname).clickonsavebutton();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(new P04_PIM(driver).ifprofilepicvisible());
        softAssert.assertAll();
        captureScreenshot(driver, "Add New Empolyee From PIM");


    }
}
