package com.automation.testng;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Parameters({"browser","environment"})
    @Test
    public void test1(String browser, String environment){
        System.out.println(browser);
        System.out.println(environment);
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @Test
    public void test3(){
        System.out.println("Test 3");
    }
}
