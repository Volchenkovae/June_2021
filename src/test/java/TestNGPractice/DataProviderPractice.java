package TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name = "fullnametest")
    public Object [][] getData(){
        return  new Object[][]{
                {"Techtorial"," Academy",  "Techtorial Academy"},
                {"Shave"," Acone",  "Shave Acone"},
                {"Grand", " Cardon", "Grand Cardon"},
                {"Kevin", " McDowel","Kevin McDowel" }
        };

    }

    @Test
    public void test1(){
        int a = 5;
        int b = 6;
        System.out.println(a+b);
        Assert.assertEquals(a+b, 11);
    }

    @Test(dataProvider = "fullnametest")
    public void test2(String firstName, String lastName, String fullName){
        String fname = firstName;
        String lname = lastName;
        String result = fname + lname;
        Assert.assertTrue(result.equals(fullName));

    }

}
