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

@Feature("Employee Search From PIM")
public class TC04_PIMEmployeeSearch extends TestBase {


    public TC04_PIMEmployeeSearch() throws IOException, ParseException {
    }

    String Username = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "Username");
    String Password = Utility.getExcelData(0, 0, "Sheet1");
    String EmployeeName = faker.regexify("[a-z]{1}");
    String EmployeeID = faker.number().digits(6);

    @Description("Check Employee Search Functionality from PIM Panel")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Check PIM Functionality for Employee Search")
    public void pimemployeeseach_P() throws InterruptedException {

        new P01_Login(driver).fillusername(Username).fillpassword(Password).clickonloginbutton();
        Thread.sleep(1500);
        new P02_Home(driver).clickonpim();
        new P04_PIM(driver).selectempname(EmployeeName).selectincludeemployee().clickonsearchbutton();
        Thread.sleep(3000);
        captureScreenshot(driver, "Search Employee From PIM");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P04_PIM(driver).checkiftrashiconvisible());
        softAssert.assertAll();
    }
}
