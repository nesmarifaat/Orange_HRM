package testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P01_Login;
import pages.P02_Home;
import pages.P03_AdminViewSystemUser;
import utilities.Utility;

import java.io.IOException;

import static utilities.Utility.captureScreenshot;
import static utilities.Utility.getSingleJsonData;

@Feature("Add New Employee")
public class TC03_AddEmployee extends TestBase {
    String Username = getSingleJsonData(System.getProperty("user.dir") + "//src//test//resources//data_driven//logindata.json", "Username");
    String Password = Utility.getExcelData(0, 0, "Sheet1");

    String NewEmployeeName = faker.regexify("[a-z]{1}");

    String Newusername = faker.name().username().substring(0, 7);
    String PasswordI = faker.internet().password(7, 12);

    public TC03_AddEmployee() throws IOException, ParseException {
    }

    @Description("Check Add new Employee Functionality from Admin panel")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Check Add New Employee Function")
    public void addnewemployee_P() throws InterruptedException {

        new P01_Login(driver).fillusername(Username).fillpassword(Password).clickonloginbutton();
        new P02_Home(driver).openadmin();
        new P03_AdminViewSystemUser(driver).clickonaddbutton().selectnewrole().selectstatus().chooseemployeename(NewEmployeeName).fillusername(Newusername).fillpassword(PasswordI).fillconfirmpassword(PasswordI).clickonsavebutton();
        Thread.sleep(4000);

        captureScreenshot(driver, "Search Employee");

    }
}
