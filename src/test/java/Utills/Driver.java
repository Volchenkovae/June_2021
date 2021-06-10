package Utills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {


    //Will implement singleton Desine Pattern
    //Will be using all drivers from this class

    // 1- create private static variables
    private static WebDriver driver;

    // 2- create private constructor
    private Driver(){}

    // 3- create the method to get your driver
    public static  WebDriver getDriver(String driverName){

        //instantiate the driver if it is equals to null

        if (driver==null) {
            switch (driverName) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;


            }
        }
        return driver;

        }
    }



