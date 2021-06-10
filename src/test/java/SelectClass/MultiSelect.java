package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiSelect {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://mdbootstrap.com/docs/b4/jquery/forms/multiselect/");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='custom-select browser-default']"));

        Select select = new Select(dropDown);
        select.selectByValue("3");
        Thread.sleep(2000);
        select.selectByIndex(1);
        Thread.sleep(2000);
        select.selectByVisibleText("Two");
        Thread.sleep(2000);
        select.deselectByValue("3");
        Thread.sleep(2000);
        select.deselectByIndex(1);
        Thread.sleep(2000);
        select.deselectByVisibleText("Two");

        select.deselectAll();
    }
}
