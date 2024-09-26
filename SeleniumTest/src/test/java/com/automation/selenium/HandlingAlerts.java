package com.automation.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingAlerts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement clickJsBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickJsBtn.click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();

        WebElement clickJsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickJsConfirm.click();

        alert.dismiss();


        WebElement clickJsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clickJsPrompt.click();

        alert.sendKeys("Java Programming");
        alert.accept();



    }
}
