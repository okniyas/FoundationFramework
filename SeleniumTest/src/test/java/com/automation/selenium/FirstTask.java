package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstTask {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("gh-ac")).sendKeys("Laptops");

        WebElement searchBtn = driver.findElement(By.cssSelector("td .gh-spr"));
        searchBtn.click();

//        driver.findElement(By.cssSelector("td #gh-cat")).click();
        WebElement catElement = driver.findElement(By.id("gh-cat"));

        //cat printing

        Select categoryDropdown = new Select(driver.findElement(By.id("gh-cat")));

        List<WebElement> option = categoryDropdown.getOptions();
//        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id='gh-cat]/option"))

        for(WebElement x : option){
            System.out.println(x.getText());
        }

        //anotherway
//        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id='gh-cat]/option"))

        //close cat printing


        Select catDropdown = new Select(catElement);
        catDropdown.selectByVisibleText("Music");
//        driver.findElement(By.cssSelector("td .gh-spr")).click();
        searchBtn = driver.findElement(By.cssSelector("td .gh-spr"));
        searchBtn.click();

        driver.findElement(By.id("gh-as-a")).click();

        WebElement title = driver.findElement(By.name("LH_TitleDesc"));
        if(!title.isSelected()){
            title.click();
        }

        WebElement completed = driver.findElement(By.name("LH_Complete"));
        if(!completed.isSelected()){
            completed.click();
        }

        WebElement sold = driver.findElement(By.name("LH_Sold"));
        if(!sold.isSelected()){
            sold.click();
        }





        driver.close();






    }

}
