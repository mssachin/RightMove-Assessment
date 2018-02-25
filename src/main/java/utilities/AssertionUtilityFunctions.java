package utilities;

import org.junit.Assert;

public class AssertionUtilityFunctions {


    public static void assertStringValue(String expected, String actual){
        Assert.assertEquals(expected, actual);
       /*try {
           Assert.assertEquals(expected, actual);
       }catch (AssertionError ae){
           ae.getMessage();
       }*/
    }

    public static void assertStringContains(String expected, String actual){

        Assert.assertTrue(actual.contains(expected));
       /* try {
            Assert.assertTrue(actual.contains(expected));
        }catch (AssertionError ae){
            ae.getMessage();
        }*/
    }
}
