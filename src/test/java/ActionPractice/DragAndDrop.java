package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        String expectedText = "Drag the small circle here.";
        String actualText = target.getText();
        Assert.assertEquals(actualText, expectedText, "Expected and actual text is not matching");

        actions.dragAndDrop(source, target).perform();

        String expectedDropText = "You did great!";
        String actualDropText = target.getText();
        Assert.assertTrue(expectedDropText.equals(actualDropText), "After drop text is not matching");

    }
    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        //clickAndHold ---->moveToElement ---->release ---->perform()
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.clickAndHold(source).moveToElement(target).release(target).perform();

    }
}
