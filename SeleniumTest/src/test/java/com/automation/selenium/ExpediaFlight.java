package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ExpediaFlight {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.expedia.co.in/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement clickOnFlight = driver.findElement(By.xpath("//a/span[text()='Flights']"));
        clickOnFlight.click();


//        WebElement clickOnOneWay = driver.findElement(By.xpath("//a/span[text()='One-way']"));
//        clickOnOneWay.click();

        WebElement leavingFrom = driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
        leavingFrom.click();

        WebElement leavingFromCity = driver.findElement(By.xpath("//input[@id='origin_select']"));
        leavingFromCity.sendKeys("Bengaluru");

        WebElement optionSelect = driver.findElement(By.xpath("//div/button[@data-stid='origin_select-result-item-button']"));
        optionSelect.click();

        //leavinto
        WebElement leavingTo = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
        leavingTo.click();



        WebElement leavingToCity = driver.findElement(By.xpath("//input[@id='destination_select']"));
        leavingToCity.sendKeys("Hyderabad");

        WebElement optionSelectTo = driver.findElement(By.xpath("//div/button[@data-stid='destination_select-result-item-button']"));
        optionSelectTo.click();

        //dates
        WebElement date = driver.findElement(By.xpath("//button[@type='button' and @name='EGDSDateRange-date-selector-trigger']"));
        date.click();

        WebElement startDate = driver.findElement(By.xpath("//table[@aria-label='July 2024']//div[text()='21']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",startDate);
//        startDate.click();

        WebElement endDate = driver.findElement(By.xpath("//table[@aria-label='July 2024']//div[text()='27']"));
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",endDate);
//        endDate.click();

        WebElement doneDate = driver.findElement(By.xpath("//button[@type='button' and @data-stid='apply-date-selector']"));
        doneDate.click();

        WebElement travellerBx = driver.findElement(By.xpath("//button[@data-stid='open-room-picker']"));
        travellerBx.click();



        WebElement searchBtn = driver.findElement(By.id("search_button"));
        searchBtn.click();






    }
}
