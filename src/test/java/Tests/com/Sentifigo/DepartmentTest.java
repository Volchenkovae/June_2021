package Tests.com.Sentifigo;

import Pages.DepartmentPage;
import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepartmentTest extends TestBase {

    DepartmentPage departmentPage;
    LoginPage loginPage;

    @BeforeClass
    public void setUpPage() {
        departmentPage = new DepartmentPage(driver);
        loginPage = new LoginPage(driver);

    }

        @Test
       public void departmentCreation() throws InterruptedException {
        driver.get("http://demo.sentrifugo.com/index.php");
        loginPage.login("EM01", "sentrifugo");

        departmentPage.departmentButton.click();
        departmentPage.addNewButton.click();
        departmentPage.departmentName.sendKeys("Finance");
        departmentPage.departmentCode.sendKeys("FN");
        departmentPage.timeZone.click();
        departmentPage.detroitTime.click();
        departmentPage.saveButton.click();
        Thread.sleep(2000);
            Assert.assertTrue(departmentPage.successMessage.isDisplayed());
        }



    }


