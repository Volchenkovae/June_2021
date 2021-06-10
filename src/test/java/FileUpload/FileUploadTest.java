package FileUpload;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {
    //when i extend this class with TestBase, I need to provide the parameter
    //if I need to provide the parameter, I should use the xml file to run my class

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/upload");
        //for file upload in Selenium, we need to send the key as a path of the file
        // which we want to upload
        //To upload the file tag of element should be "input" and type should be "file"
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/elena/Desktop/FileUploadTest.png");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.submit();

        WebElement textMessage = driver.findElement(By.id("uploaded-files"));
        String actualText = textMessage.getText();
        String expectedText = "FileUploadTest.png";

        softAssert.assertEquals(actualText, expectedText);
        softAssert.assertAll();

    }
}
