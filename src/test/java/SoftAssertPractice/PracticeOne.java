package SoftAssertPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeOne {
    @Test
    public void test2(){
        Assert.assertEquals(4, 4, "The integer number verification");
        Assert.assertTrue("Techtorial".startsWith("Tech"), "Boolean condition verified");
        Assert.assertEquals("Tech", "Tech", "String values verified");
    }

    @Test
    public void test3(){
        Assert.assertEquals(4, 4, "The integer number verification");

    }
    @Test
    public void test1(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(3, 4, "The integer number verification");
        softAssert.assertTrue("Techtorial".startsWith("Tech"), "Boolean condition verified");
        softAssert.assertEquals("Tech", "Tech", "String values verified");

        softAssert.assertAll();
        System.out.println("Hello World!");
    }


}
