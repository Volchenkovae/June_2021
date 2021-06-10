package Tests.com.Sentifigo;

import Pages.LoginPage;
import Pages.MeritalStatusPage;
import Tests.TestBase;
import Tests.com.Sentifigo.TestData.MeritalStatusData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MeritalStatusTest extends TestBase {


    MeritalStatusPage page;
    LoginPage loginPage;

    @BeforeClass
    public void setUpPage(){
        page = new MeritalStatusPage(driver);
        loginPage = new LoginPage(driver);

    }

    // userName = "EM01", password = "sentrifugo"
    @Parameters({"userName", "password"})
    @Test(priority = 1)
    public void validationErrorMessage(String user, String pass){
        driver.get("http://demo.sentrifugo.com/index.php");
        loginPage.login(user, pass);
        page.ganderButton.click();
        page.maritalStatusButton.click();
        page.addButton.click();
        page.saveButton.click();
        String actualCodeError = page.errorMaritalCode.getText();
        String expectedCodeError = "Please enter marital code.";
        String actualStatusError = page.errorMaritalStatuseName.getText();
        String expectedStatusError = "Please enter marital status.";

        //soft assert
        softAssert.assertEquals(actualCodeError, expectedCodeError);
        softAssert.assertEquals(actualStatusError, expectedStatusError);

        //assertAll should be at the end of you test annotation;
        softAssert.assertAll();

        //System.out.println("This is for soft assert");
        //Hard assertion
        //Assert.assertEquals(actualCodeError, expectedCodeError);
        //Assert.assertEquals(actualStatusError, expectedStatusError);

    }
    @Test(priority = 2, dataProvider = "maritalStatus", dataProviderClass = MeritalStatusData.class)
    public void validationMaritalStatusCreation(String code, String status, String description) throws InterruptedException {

        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        page.maritalCode.sendKeys(code);
        page.maritalStatusName.sendKeys(status);
        page.description.sendKeys(description);
        page.saveButton.click();
        Thread.sleep(400);
        //Even though my assertion is failing I want to click addButton.
        softAssert.assertTrue(page.successMessage.isDisplayed());
        //Assert.assertTrue(page.successMessage.isDisplayed());
        page.addButton.click();

        softAssert.assertAll();
    }

}
