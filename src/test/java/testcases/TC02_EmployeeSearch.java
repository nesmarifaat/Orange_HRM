package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_Login;
import pages.P02_Home;
import pages.P03_AdminViewSystemUser;
import utilities.Utility;

import java.io.IOException;

import static utilities.Utility.captureScreenshot;
import static utilities.Utility.getSingleJsonData;

@Feature("Search Functionality")
@Epic("Search Epic")
public class TC02_EmployeeSearch extends TestBase {
    String Username = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "Username");
    String Password = Utility.getExcelData(0, 0, "Sheet1");
    String Employee_Name = faker.regexify("[a-z]{1}");
    ;

    public TC02_EmployeeSearch() throws IOException, ParseException {
    }

    @Description("Check search employee functionality from Admin Panel")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Check Employee Search Function")
    public void checksearchfunction_P() throws InterruptedException {
        new P01_Login(driver).fillusername(Username).fillpassword(Password).clickonloginbutton();
        new P02_Home(driver).openadmin();
        new P03_AdminViewSystemUser(driver).openuserroledropdown().filluasername(Username).selectrole().fillemployeename(Employee_Name).selectstatus().clickonsearchbutton();
        captureScreenshot(driver, "Search Employee");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P03_AdminViewSystemUser(driver).checksearchrecord());
        softAssert.assertAll();
    }
}
