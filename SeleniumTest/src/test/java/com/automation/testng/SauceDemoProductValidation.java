package com.automation.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SauceDemoProductValidation {

    WebDriver driver;
    WebElement username, password, login;

    @Test
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        username = driver.findElement(By.id("user-name"));
        password = driver.findElement(By.id("password"));
        login = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
        List<WebElement> products;
        products = driver.findElements(By.xpath("//div[@data-test='inventory-item']"));

        WebElement productName;
        WebElement productPrice;
        String name;
        String price;
        WebElement insideName;
        WebElement insidePrice;
        WebElement product;

        for(int i=0; i<products.size();i++)
        {

            product = driver.findElement(By.xpath("//div[@data-test='inventory-item']["+(i+1)+"]"));

            productName = product.findElement(By.xpath(".//div[@data-test='inventory-item-name']"));
            productPrice = product.findElement(By.xpath(".//div[@data-test='inventory-item-price']"));

            name = productName.getText();
            price = productPrice.getText();

            productName.click();
            insideName = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
            insidePrice = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));

            Assert.assertEquals(name, insideName.getText(),"The product names does not match");
            Assert.assertEquals(price, insidePrice.getText());

            driver.navigate().back();

        }



    }

//    @Test
//    public void validateProduct(){
//
//    }

}
