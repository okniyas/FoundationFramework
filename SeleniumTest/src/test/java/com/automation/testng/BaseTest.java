package com.automation.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement login;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("www.saucedemo.com");
//        username = driver.findElement(By.id("user-name"));
//        password = driver.findElement(By.id("password"));
//        login = driver.findElement(By.id("login-button"));

//        System.out.println("Before");
    }

    @AfterMethod
    public void clean(){
        driver.quit();
//        System.out.println("After");
    }
}
