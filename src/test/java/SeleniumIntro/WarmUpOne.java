package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WarmUpOne {

    public static void main(String[] args) {
        String driverPath = "/Users/elena/Downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.ru/");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");

        WebElement googleSearch = driver.findElement(By.xpath("//div[@class = 'FPdoLc tfB0Bf']//input[@class = 'gNO89b']"));
        googleSearch.click();

        List<WebElement> header = driver.findElements(By.xpath("//h3[@class = 'LC20lb DKV0Md']"));
        for (WebElement h:header){
            String hd = h.getText();
            //if (!hd.equals("")){
                if (hd.contains("selenium")|| hd.contains("Selenium")){
                    System.out.println("Include Selenium");

                }else{
                    System.out.println("Doesn't include Selenium");
                }
            }

        }
    }

