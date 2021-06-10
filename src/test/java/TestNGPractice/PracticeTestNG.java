package TestNGPractice;

import org.testng.annotations.*;

public class PracticeTestNG {


    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit Annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test Annotation");
    }
    @BeforeClass
    public void befoteClass(){
        System.out.println("Before Class Annotation");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method Annotation");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("Test - 1");
    }

    @Test(priority = 1, enabled = false)
    public void test2(){
        System.out.println("Test - 2");
    }

    @Test(alwaysRun = true)
    public void test3(){
        System.out.println("Test - 3");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method Annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class Annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test Annotation");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("After Suit Annotation");
    }
}
