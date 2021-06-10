package TestNgIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {

    @Test
    public void test1(){
        System.out.println("First Test");
        Assert.assertEquals("Mothers Day", "Mothers Day");
        System.out.println("After assertion");
    }
    @Test
    public void test2(){
        System.out.println("Second Test");
        Assert.assertTrue("Mothers Day".startsWith("Mother"));
        System.out.println("After second assertion");

    }
}
