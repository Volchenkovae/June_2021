package SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitlyWait {


    WebDriver driver;

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement message=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message"))));

        String actualText = message.getText();
        String expectedText = "It's gone!";
        Assert.assertEquals(actualText, expectedText);


    }

}
