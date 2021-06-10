package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeybordClass {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));


        Actions actions = new Actions(driver);
        /*
        1 - move to element;
        2 - click the element;
        3 - click the shift button on keyboard;
        we need to use KeyDown(element, Keys) method
        4 - send search value Selenium;
        5 - unclick  the shift button;
        6 - double click the element;
        7 - right click in the element;
         */

        actions.moveToElement(searchBox).click().keyDown(searchBox, Keys.SHIFT)
                .sendKeys(searchBox, "selenium")
                .keyUp(searchBox, Keys.SHIFT)
                .doubleClick(searchBox)
                .contextClick().perform();

        // keys is working with Actions class and with WebElement

        searchBox.sendKeys(Keys.ARROW_DOWN);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        searchBox.sendKeys(Keys.ARROW_DOWN);// Select the selenium sulfide
        Thread.sleep(1000);
        searchBox.sendKeys(Keys.ENTER);


        Assert.assertTrue(driver.getTitle().contains("selenium sulfide"));
        //evaluate the expression

    }
}
