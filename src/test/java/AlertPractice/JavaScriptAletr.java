package AlertPractice;

import Utills.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAletr {

    WebDriver driver;

    @BeforeClass
    public void setDriver(){
        driver = Driver.getDriver("chrome");
    }
    @Test
    public void sweetAlertTest() throws InterruptedException {
        driver.navigate().to("https://sweetalert.js.org/");

        driver.findElement(By.xpath("//button[contains(@onclick, 'swal')]")).click();
        Thread.sleep(1000);
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'swal-text']")).getText();
        String expectedMessage = "Something went wrong!";
        Assert.assertEquals(actualMessage, expectedMessage,"Message is validated");
        driver.findElement(By.xpath("//button[.='OK']")).click();

    }
    @Test
    public void javaScriptAlertTest1() throws InterruptedException {
        driver.navigate().to("https://sweetalert.js.org/");
        driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]")).click();
        Thread.sleep(1000);

        //since for JavaScript alert we do not have webelement
        //we need to switch the driver to alert class
        Alert alert = driver.switchTo().alert();
        //We have 4 metods for Alert class to handle the js alerts.
        //1-accept(Ok), 2-dismiss(decline), 3-sentKeys, 4-getText

        String actualAlertJSMessage = alert.getText();//will return text of alert
        String expectedMessage = "Oops, something went wrong!";
        Assert.assertEquals(actualAlertJSMessage, expectedMessage);

        alert.accept();//it will click OK button in JS alert

    }
    @Test
    public void jsSendKeyTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsButton.click();

        SoftAssert softAssert = new SoftAssert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You clicked: Cancel";
        softAssert.assertEquals(actualResult, expectedResult, "cancel button is validated");

        jsButton.click();
        alert.accept();
        String actualResult1 = driver.findElement(By.id("result")).getText();
        String expectedResult1 = "You clicked: Ok";
        softAssert.assertEquals(actualResult,expectedResult);

        softAssert.assertAll();

    }
}
