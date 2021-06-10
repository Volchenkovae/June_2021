package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Xpath {
    public static void main(String[] args) {
        String driverPath = "/Users/elena/Downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver;
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/typos");

        WebElement typo = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(typo.getText());

        WebElement typo2 = driver.findElement(By.xpath("//h3"));
        System.out.println(typo2.getText());

        List<WebElement> paragraphs = driver.findElements(By.xpath("//p"));
        for (WebElement paragraph:paragraphs){
            System.out.println(paragraph.getText());
        }
        //a[contains(@href,'notification')]
        driver.navigate().to("https://the-internet.herokuapp.com");
        WebElement notification = driver.findElement(By.xpath("//a[contains(@href,'notification')]"));
        System.out.println(notification.getText());
        notification.click();
        driver.navigate().back();

        WebElement notification2 = driver.findElement(By.xpath("//a[contains(text(),'Notification')]"));
        System.out.println(notification2.getText());



        //driver.close();

    }

}
