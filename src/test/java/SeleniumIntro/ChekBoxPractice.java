package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChekBoxPractice {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        WebElement searchButton = driver.findElement(By.xpath("//div/span/input[@type='submit']"));
        searchButton.submit();
        WebElement apple = driver.findElement(By.xpath("//li[@id='p_89/Apple']//i"));
        apple.click();
        Thread.sleep(1000);
        apple = driver.findElement(By.xpath("//li[@id='p_89/Apple']//input"));

        Assert.assertTrue(apple.isSelected());


    }
}
