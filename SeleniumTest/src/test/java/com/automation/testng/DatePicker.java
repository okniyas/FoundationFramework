package com.automation.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePicker {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.expedia.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        String checkInDate = "18 October 2024";
        String checkOutDate = "13 November 2024";
        driver.findElement(By.xpath("//button[contains(@name,'date-selector')]")).click();
        selectdate(checkInDate,driver);
        selectdate(checkOutDate,driver);
        WebElement doneDateSelector = driver.findElement(By.xpath("//button[@data-stid='apply-date-selector']"));
        doneDateSelector.click();

    }

    public static void selectdate(String date, WebDriver driver) throws InterruptedException {
        String xpathDay = "//div[contains(@class,'uitk-month-double-left')]//div[contains(@class,'date-number') and text()='%s']";
        String monthYear = date.substring(date.indexOf(' ')+1);
        String day = date.substring(0, date.indexOf(' '));

        WebElement monthYearElement = driver.findElement(By.xpath("//div[contains(@class, 'uitk-month-double-left')]//span[contains(@class, uitk-month-label)]"));

        while(!monthYear.equals(monthYearElement.getText())){
            WebElement nextBtn = driver.findElement(By.xpath("//button[@data-stid='uitk-calendar-navigation-controls-next-button']"));
            nextBtn.click();
            monthYearElement = driver.findElement(By.xpath("//div[contains(@class, 'uitk-month-double-left')]//span[contains(@class, uitk-month-label)]"));
            Thread.sleep(1000);
        }

        String dayLocator = String.format(xpathDay, day);
        WebElement dayElement = driver.findElement(By.xpath(dayLocator));
        dayElement.click();
        Thread.sleep(1000);


    }
}
