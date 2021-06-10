package Utills;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtills {
    public static void switchWindowByTitle(WebDriver driver, String targetTitle) {

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);

            }
        }
    }

    public static void switchWindowUrl(WebDriver driver, String URl) {
        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            if (!driver.getCurrentUrl().contains(URl)) {
                driver.switchTo().window(id);

            }
        }
    }

    public static void closeAllWindows(WebDriver driver, String parentID) {
        Set<String> ids = driver.getWindowHandles();

        for (String id : ids){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }
}
