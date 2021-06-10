package IframePractice;

import Utills.BrowserUtills;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class IframeIntro {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.id("tinymce"));
        System.out.println(textBox.getText());

        driver.switchTo().defaultContent();
        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());


    }

    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.id("content"));
        System.out.println(middle.getText());


        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//body[contains(. , 'RIGHT')]"));
        System.out.println(right.getText());

    }
    @Test
    public void test3(){
        driver.get("https://skpatro.github.io/demo/iframes/");

        driver.switchTo().frame("Frame1");

        WebElement category2 = driver.findElement(By.xpath("//a[.='Category2']"));
        category2.click();
        BrowserUtills.switchWindowUrl(driver, "basicjava");
        System.out.println(driver.getTitle());


        BrowserUtills.switchWindowByTitle(driver, "iframes");
        driver.switchTo().frame(1);
        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();

    }
    @Test
    public void test4(){
        driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@name = 'packageListFrame']"));

        driver.switchTo().frame(frameElement);
        List<WebElement> pakageNames = driver.findElements(By.xpath("//a[@target='packageFrame']"));
        for (WebElement pakageName : pakageNames){
            System.out.println(pakageName.getText());
        }
    }
}
