package com.automation.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MonkeyType {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://monkeytype.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


        //my code--------->>

        List<WebElement> words;
        WebElement inputField = driver.findElement(By.id("wordsInput"));
        while (true) {
            try {
                words = driver.findElements(By.xpath("//div[@id='words']/div[@class='word active']/letter"));
                for (int i = 0; i < words.size(); i++) {
                    WebElement letter = driver.findElements(By.xpath("//div[@id='words']/div[@class='word active']/letter")).get(i);
                    String original = letter.getText();
                    inputField.sendKeys(original);
                }
                inputField.sendKeys(" ");
            } catch (Exception e) {
                System.out.println("finished " + e.getMessage());
                break;
            }

        }

        //end----------------------------->

//        List<WebElement> wordsList =driver.findElements(By.xpath("//div[@class='word active']/letter"));
//        WebElement input=driver.findElement(By.id("wordsInput"));
//
//        List<String> words = wordsList.stream()
//                .map(WebElement::getText)
//                .toList();
//        while (!words.isEmpty()){
//
//            for (String word:words){
//                input.sendKeys(word);
//            }
//
//            input.sendKeys(" ");
//            wordsList =driver.findElements(By.xpath("//div[@class='word active']/letter"));
//            words = wordsList.stream()
//                    .map(WebElement::getText)
//                    .toList();
//
//        }



    }
}
