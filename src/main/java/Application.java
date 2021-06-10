import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("test");
        String driverPath = "/Users/elena/Downloads/chromedriver";
        WebDriver driver;
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.navigate().to("http://google.com");

        //driver.close();

        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");

        WebElement saveButton = driver.findElement(By.id("demo"));
        System.out.println(saveButton.isEnabled());

        WebElement radioButton = driver.findElement(By.id("java1"));
        radioButton.click();
        System.out.println(radioButton.isEnabled());
        Thread.sleep(2000);
        System.out.println(saveButton.isEnabled());

        WebElement seleniumBox = driver.findElement(By.id("seleniumbox"));
        System.out.println(seleniumBox.isSelected());

        driver.close();
    }
}
