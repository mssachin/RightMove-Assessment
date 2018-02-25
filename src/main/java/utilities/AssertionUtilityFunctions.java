package utilities;

import org.junit.Assert;

public class AssertionUtilityFunctions {


    public static void assertStringValue(String expected, String actual){
        Assert.assertEquals(expected, actual);

    }

    public static void assertStringContains(String expected, String actual){

        Assert.assertTrue(actual.contains(expected));

    }
}
