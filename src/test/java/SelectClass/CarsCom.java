package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CarsCom {

    @Test
    public void newUsedSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cars.com/");
        WebElement newUsed = driver.findElement(By.xpath("//select[@aria-label='Select a stock type']"));

        //for dropDown box create object from Select class
        //it will take one parameter as element
        //tag of the element must be select for Select class

        Select select = new Select(newUsed);
        select.selectByVisibleText("Certified Cars");
        Thread.sleep(2000);
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByValue("28880");

        //return type of getOptions will List<Webelements>
        List<WebElement> options = select.getOptions();
        for (WebElement opt : options) {
            System.out.println(opt.getText());

            //WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
            //searchButton.click();
        }

    }
}

