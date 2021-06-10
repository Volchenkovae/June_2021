package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDropPR {

    WebDriver driver;
    //How we can use implicitly wait. It takes two parameters (int Value, timeUnits)
    @BeforeClass
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //It will wait 5 sec until the elements are loaded in the page
            //If you are not able to find the element after 5 sec, Selenium will throw NoSuchElementException.

        }
        @Test
        public void test1 () {

            WebElement circle = driver.findElement(By.id("draggable"));
            WebElement blueBox = driver.findElement(By.className("test1"));
            WebElement orangeBox = driver.findElement(By.className("test2"));

            //drag and drop from only with Actions class
            String expected = "Drag the small circle here ...";
            String actual = blueBox.getText();
            Assert.assertEquals(actual, expected, "Default text in blue box is failed");

            String expectedOrangeText = "... Or here.";//expected coming from Business Requarenments
            String actualOrangeText = orangeBox.getText();
            Assert.assertEquals(actualOrangeText, expectedOrangeText, "Default text in orange box is failed");


        }
        @Test
        public void test2(){
            WebElement circle = driver.findElement(By.id("draggable"));
            WebElement blueBox = driver.findElement(By.className("test1"));
            WebElement orangeBox;

            Actions actions = new Actions(driver);
            actions.dragAndDrop(circle, blueBox).perform();
            blueBox = driver.findElement(By.className("test1"));
            String expectedBlueBoxText = "You did great!";

            String actualBlueBoxText = blueBox.getText();
            Assert.assertEquals(actualBlueBoxText, expectedBlueBoxText, "After dropping blue box text is faild");

            String expectedOrangeBoxText = "(Drop here)";
            orangeBox = driver.findElement(By.className("test2"));
            String actualOrangeBoxText = orangeBox.getText();
            Assert.assertEquals(actualOrangeBoxText, expectedOrangeBoxText, "After dropping Blue Box, orange box message is failed");


        }
        @Test
    public void test3(){
            WebElement circle = driver.findElement(By.id("draggable"));
            WebElement blueBox;
            WebElement orangeBox = driver.findElement(By.className("test2"));
            Actions actions = new Actions(driver);

            //this process is moving circle inside the Orange Box
            actions.clickAndHold(circle).moveToElement(orangeBox).release().perform();
            String expectedOrangeBox = "You did great!";
            orangeBox = driver.findElement(By.className("test2"));
            String actualOrangeBox = orangeBox.getText();
            Assert.assertEquals(actualOrangeBox, expectedOrangeBox);

            String expectedBlueBox = "(Drop here)";
            blueBox = driver.findElement(By.className("test1"));
            String actualBlueBox = blueBox.getText();
            Assert.assertEquals(actualBlueBox, expectedBlueBox);

        }

        @AfterClass
    public void tearDown(){
        driver.quit();
        }
    }

