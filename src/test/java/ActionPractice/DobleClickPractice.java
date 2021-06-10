package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class DobleClickPractice {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml?jfwid=a7fc7");

        List<WebElement> catalog = driver.findElements(By.xpath("//div[contains(text(), 'click')]"));
        Actions actions = new Actions(driver);
        for (WebElement element : catalog){
            switch (element.getText()){
                case "click":
                    element.click();
                    break;
                case "doubleclick":
                    actions.doubleClick(element).perform();
                    break;

            }
        }


    }
}
