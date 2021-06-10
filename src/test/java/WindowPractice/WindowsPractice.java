package WindowPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsPractice {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//It will open your driver
        //maximize or fullscreen
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    @Test
    public void test1(){

        WebElement clickHearButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHearButton.click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        String parentPageId = driver.getWindowHandle();
        System.out.println(parentPageId);
        Set<String> pageIds = driver.getWindowHandles();
        for (String id : pageIds){
            if(!id.equals(parentPageId)){
                driver.switchTo().window(id);
            }
        }
        System.out.println("After switching title: " + driver.getTitle());
        System.out.println("After switching URL: " + driver.getCurrentUrl());

        driver.switchTo().window(parentPageId);
        clickHearButton.click();
    }


    }

