package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class JavascriptExecutorExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement searchBx = driver.findElement(By.id("gh-ac"));
//        addBorder(searchBx,driver);
        searchBx.sendKeys("Laptop");

        WebElement searchBtn = driver.findElement(By.id("gh-btn"));
//        addBorder(searchBtn,driver);
        searchBtn.click();

        //main code of JavascriptExecutor
        for(int i=1;i<=10;i++) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].style.border = '2px solid red';",element);
            javascriptExecutor.executeScript("window.scrollBy(0,250)");
            Thread.sleep(1000);
        }

    }
}
