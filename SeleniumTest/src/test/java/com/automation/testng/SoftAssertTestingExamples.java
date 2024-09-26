package com.automation.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTestingExamples {

    @Test
    public void softAssertTest(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(4,4);
        softAssert.assertEquals(10,11);
        softAssert.assertEquals(20,20);
        softAssert.assertEquals(30,20);
        softAssert.assertTrue(10 >= 11);
        softAssert.assertAll();
    }
}
