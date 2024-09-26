package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MintedExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.minted.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement mailId = driver.findElement(By.xpath("//input[@type='email' and @placeholder='Email address']"));
        mailId.sendKeys("niyas@ust.com");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.visibilityOf(mailId));
//        mailId.sendKeys("niyas@ust.com");




////form[@method='post']//input[@type='email']


    }
}
