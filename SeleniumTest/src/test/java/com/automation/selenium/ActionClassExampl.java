package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClassExampl {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ebay.com");

        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement electronicsLink = driver.findElement(By.xpath("//li/a[text()='Electronics']"));
        WebElement appleLink = driver.findElement(By.xpath("//a[text()='Apple']"));

        Actions action = new Actions(driver);
//        action.moveToElement(electronicsLink).pause(1000).click(appleLink).build().perform();
        action.moveToElement(electronicsLink).pause(1000)
                .keyDown(Keys.CONTROL).click(appleLink).keyUp(Keys.CONTROL)
                .build().perform();
    }
}
