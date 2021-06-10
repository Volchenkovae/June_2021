package SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitPractice {

    WebDriver driver;

    @Test(enabled = false)
    public void test1(){
        WebDriverManager.chromedriver().setup();//chromeDriver
        driver = new ChromeDriver();
        //it will wait 10 sec until page loaded, if page will load in 3 sec rest of 7 sec will ignored
        //if after 10 sec page will not be loaded, will throw exeption
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //implicitly wait will wait all your Webelement which your driver is pointing
        //it will throws NoSuchElementException if the element is not available
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //it will wait for an asynchronous script in your page
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");


    }

    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();//chromeDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        WebElement message = driver.findElement(By.id("message"));
        String actualText = message.getText();
        String expectedText = "It's gone!";

        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(actualText, expectedText);

    }
}
