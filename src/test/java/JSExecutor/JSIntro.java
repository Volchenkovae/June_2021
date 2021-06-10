package JSExecutor;

import Tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSIntro extends TestBase {

    @Test(enabled = false)
    public void test1() throws InterruptedException {
        driver.get("https://www.techtorialacademy.com/");

        //1 - we need to cast our driver to JSExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;//casting our driver to JJSExecuter
        String title = jsExecutor.executeScript("return document.title;").toString();
        System.out.println(title);
        WebElement browsCours = driver.findElement(By.xpath("//a[.='Browse Course']"));

        jsExecutor.executeScript("arguments[0].click()", browsCours);

        title = jsExecutor.executeScript("return document.title;").toString();
        System.out.println(title);

        jsExecutor.executeScript("alert('Techtorial academy JSExecuter Test')");

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement getStarted = driver.findElement(By.xpath("//h4[.='On-Campus Course']/following-sibling::div/a"));
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getStarted);



    }
    @Test
    public void test2(){
        driver.get("https://www.techtorialacademy.com/");
        //i want to refresh my page
        //driver.navigate().refresh();-->it will refresh website
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("history.go(0)");
        //Using JSExecuter we want to scroll the page until end of it.

    }
}
