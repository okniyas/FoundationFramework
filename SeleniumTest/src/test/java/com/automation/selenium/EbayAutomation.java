package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class EbayAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement searchBx = driver.findElement(By.id("gh-ac"));
        addBorder(searchBx,driver);
        searchBx.sendKeys("Laptop");

        WebElement searchBtn = driver.findElement(By.id("gh-btn"));
        addBorder(searchBtn,driver);
        searchBtn.click();

        List<WebElement> laptopsTitle = driver.findElements(By.xpath("//ul/li//div[@class='s-item__title']"));
//        List<WebElement> laptopsPrice = driver.findElements(By.xpath("//ul/li//div[@class='s-item__title']"));

        //Switch to new window
        String originalWindow = driver.getWindowHandle();
//        Set<String> listOfWindow = driver.getWindowHandles();

        //price //ul/li//div/span[@class='s-item__price']
        for(WebElement laptopTitle : laptopsTitle){
            addBorder(laptopTitle,driver);
            laptopTitle.click();

            Set<String> listOfWindow = driver.getWindowHandles();

            for(String newWindow : listOfWindow){
                if(!newWindow.equals(originalWindow)){
                    driver.switchTo().window(newWindow);
                }
            }

            System.out.println(driver.findElement(By.xpath("//h1/span")).getText());
            System.out.println(driver.findElement(By.xpath("//div[@class='x-price-primary']/span")).getText());
            driver.close();
            driver.switchTo().window(originalWindow);

        }





    }
    public static void addBorder(WebElement element, WebDriver driver){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].style.border = '2px solid red';",element);
    }
}
