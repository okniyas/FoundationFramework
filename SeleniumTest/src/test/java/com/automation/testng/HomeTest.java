package com.automation.testng;

import org.testng.annotations.Test;

public class HomeTest extends BaseTest{

    @Test(groups = "smoke Test")
    public void test6(){
        System.out.println("Test 6");
    }

    @Test(groups = "smoke Test")
    public void test7(){
        System.out.println("Test 7");
    }

    @Test(groups = "completed")
    public void test8(){
        System.out.println("Test 8");
    }

    @Test(groups = "wip")
    public void test9(){
        System.out.println("Test 9");
    }
}
