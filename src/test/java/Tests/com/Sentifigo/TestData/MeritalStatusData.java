package Tests.com.Sentifigo.TestData;

import org.testng.annotations.DataProvider;

public class MeritalStatusData {
    @DataProvider(name = "maritalStatus")
    public Object [][] getData() {

        return new Object[][]{
                {"SS", "SSingle", "test1"},
                {"MM", "MMaried", "test2"},
                {"DD", "DDivorced", "test3"},


        };
    }}
