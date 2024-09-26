package com.automation.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmountFieldTestExample {

    @Test(dataProvider = "PositiveDataProvider")
    public void test1(String amount){
        System.out.println("Positive test with "+amount);
    }

    @Test(dataProvider = "NegativeDataProvider")
    public void test2(String amount){
        System.out.println("Negative test with "+amount);
    }

    @DataProvider(name = "PositiveDataProvider")
    public Object[] getPositiveData(){
        Object[] data = {"1", "12", "10.54","100"};
        return data;
    }

    @DataProvider(name = "NegativeDataProvider")
    public Object[] getNegativeData(){
        Object[] data = {"0.9", "-5","100.1","abc","10/2", "0.0009"};
        return data;
    }
}
