package TestNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterPractice {


    //we need to give the value to our parameter annotation from xml runner class
    //if you use parameter annotation you should provide the value inside the runner class
    // @Parameters("name") --> name is the key
    @Parameters({"name", "lastName"})
    @Test
    public void test1(String name, String lastName){
        System.out.println("Name is "+ name);
        System.out.println("Last name is "+ lastName);
    }
}
