package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderAction {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type = 'range']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider)
                .moveByOffset(-55, 0)
                .release()
                .perform();

    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type = 'range']"));
        WebElement number = driver.findElement(By.id("range"));
        Actions actions = new Actions(driver);
        int xOffset = -55;
        while (!number.getText().equals("5")) {
            actions.clickAndHold(slider)
                    .moveByOffset(xOffset, 0)
                    .release()
                    .perform();
            xOffset += 10;
        }

    }

    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type = 'range']"));
        WebElement number = driver.findElement(By.id("range"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).perform();
        while (!number.getText().equals("5")) {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();

        }

    }

    @Test
    public void test4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/keyboard-navigation");
        WebElement first = driver.findElement(By.xpath("//a[contains(@style,'left: -8px')]"));
        WebElement second = driver.findElement(By.xpath("//a[contains(@style,'left: 190px;')]"));
        Point point = first.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
        System.out.println(xcord);
        System.out.println(ycord);

        Point point2 = second.getLocation();
        System.out.println(point2.getX());
        System.out.println(point2.getY());

        Actions actions = new Actions(driver);
        actions.clickAndHold(first).moveByOffset(200, 0).release().perform();
        actions.clickAndHold(second).moveByOffset(-200, 0).release().perform();

    }

    @Test
    public void test5(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/angular");

        WebElement vertical = driver.findElement(By.xpath("//a[@style='bottom: -8px;']"));

        WebElement ten = driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title = '10']"));
        WebElement zero = driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title = '0']"));

        Point tenY = ten.getLocation();
        System.out.println(tenY.getY());
        Point zeroY = zero.getLocation();
        System.out.println(zeroY.getY());
        System.out.println(tenY.getY()-zeroY.getY());


        //557-645 = -88
        Actions actions = new Actions(driver);
        actions.clickAndHold(vertical).moveByOffset(0,-88).release().perform();
        actions.clickAndHold(vertical).moveByOffset(0,40).release().perform();

}

}






