package com.automation.testng;

import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{

    @Test(groups = "smoke Test")
    public void test10(){
        System.out.println("Test 10");
    }

    @Test
    public void test11(){
        System.out.println("Test 11");
    }

    @Test
    public void test12(){
        System.out.println("Test 12");
    }

    @Test(groups = "wip")
    public void test13(){
        System.out.println("Test 13");
    }
}
