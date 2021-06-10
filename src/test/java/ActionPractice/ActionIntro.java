package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionIntro {

    @Test
    public void rightClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement hotSpots = driver.findElement(By.id("hot-spot"));

        //Inside this Actions constructor we need provide driver
        Actions actions = new Actions(driver);

        //ContextClick will perform Right Click actions in mouse
        //In actions class we need to use perform() method to see the mouse action
        actions.contextClick(hotSpots).perform();


    }

    @Test
    public void rightClick1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement hotSpots = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //Using action interface

        Action action = actions.contextClick(hotSpots).build();
        action.perform();

    }

    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> avatarText = driver.findElements(By.xpath("//h5"));
        for (WebElement a: avatarText){
            System.out.println(a.getText());
        }

        List<WebElement> avatars = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        Actions actions = new Actions((driver));

        int count = 0;

        for (WebElement avatar: avatars){
            actions.moveToElement(avatar).perform();

            System.out.println(avatarText.get(count++).getText());

            Thread.sleep(1000);

        }

    }


    }

