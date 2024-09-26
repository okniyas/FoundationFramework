package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Herokuapp {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();


        ////table[@id='table1']//td[not(a)]
        ////table[@id='table1']/tbody/tr

//        List<WebElement> tableElements = driver.findElements(By.xpath("//table[@id='table1']//td[not(a)]"));
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for(int i=1;i<= tableRows.size();i++){
            List<WebElement> tableElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[not(a)]"));
//            for(int j =0;j<=tableElements.size()-1;j++){
//                System.out.print(tableElements.get(j).getText()+"  ");
//            }
            for(WebElement tableElement : tableElements){
                System.out.print(tableElement.getText()+"  ");
            }

            System.out.println();
        }


        driver.close();






    }

}

