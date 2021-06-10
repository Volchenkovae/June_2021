package Tests.com.Sentifigo;

import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage page;
    @BeforeClass
    public void pageSetUp(){
        page = new LoginPage(driver);

    }

    @Parameters({"userName", "password"})
    //All test annotation will be implemented in this class
    @Test
    public void loginTest1(String userName, String password){
        driver.get("http://demo.sentrifugo.com/index.php");
        page.userName.sendKeys("userName");
        page.password.sendKeys("password");
        page.loginButton.click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://demo.sentrifugo.com/index.php/index";
        Assert.assertEquals(actualURL, expectedURL);


    }
}
