package com.automation.testng;

import jdk.jfr.Enabled;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = "smoke Test")
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(groups = "smoke Test")
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(enabled = true, groups = "smoke Test")
    public void test3(){
        System.out.println("Test 3");
    }

    @Test(groups = {"smoke Test", "Completed"})
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(groups = "wip")
    public void test5(){
        System.out.println("test 5");
    }
}
