package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import java.time.Duration;

public class SauceDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginClick = driver.findElement(By.id("login-button"));
        loginClick.click();

        WebElement addToCartBagItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartBagItem.click();

        WebElement clickOnAllCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        clickOnAllCart.click();

        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart_item']"));
//        List<WebElement> cartDetails;

        System.out.println("Cart Items :");
        for(WebElement item : cartItems){
            WebElement title = item.findElement(By.xpath("./div/a/div"));
            System.out.println("title: "+title.getText()+ "  ");

            WebElement description = item.findElement(By.xpath(".//div[@class='inventory_item_desc']"));
            System.out.println("Description: "+ description.getText()+" ");

            WebElement price = item.findElement(By.xpath(".//div[@class='inventory_item_price']"));
            System.out.println("Price: "+ price.getText()+" ");

            System.out.println();


        }

        WebElement clickOnCheckOut = driver.findElement(By.id("checkout"));
        clickOnCheckOut.click();

        WebElement fname = driver.findElement(By.id("first-name"));
        WebElement lname = driver.findElement(By.id("last-name"));
        WebElement pincode = driver.findElement(By.id("postal-code"));
        fname.sendKeys("Niyas");
        lname.sendKeys("O K");
        pincode.sendKeys("673573");

        WebElement afterAddress = driver.findElement(By.xpath("//input[@type='submit']"));
        afterAddress.click();

        System.out.println("Checkout Overview");
//        for(WebElement item : cartItems){
//            WebElement title = item.findElement(By.xpath("./div/a/div"));
//            System.out.println("title: "+title.getText()+ "  ");
//
//            WebElement description = item.findElement(By.xpath(".//div[@class='inventory_item_desc']"));
//            System.out.println("Description: "+ description.getText()+" ");
//
//            WebElement price = item.findElement(By.xpath(".//div[@class='inventory_item_price']"));
//            System.out.println("Price: "+ price.getText()+" ");
//
//            System.out.println();
//
//
//        }
        WebElement paymentId = driver.findElement(By.xpath("//div[@data-test='payment-info-value']"));
        System.out.println("Payment Information : "+ paymentId.getText());

        System.out.println();

        WebElement shippingInfo = driver.findElement(By.xpath("//div[@data-test='shipping-info-value']"));
        System.out.println("Shipping : "+ shippingInfo.getText());

        System.out.println();

        System.out.println("Price Total : ");
        WebElement itemTotal = driver.findElement(By.xpath("//div[@data-test='subtotal-label']"));
        System.out.println(itemTotal.getText());

        WebElement tax = driver.findElement(By.xpath("//div[@data-test='tax-label']"));
        System.out.println(tax.getText());

        WebElement total = driver.findElement(By.xpath("//div[@data-test='total-label']"));
        System.out.println(total.getText());

        WebElement finish = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium cart_button']"));
        finish.click();

        System.out.println();

        WebElement thankYou = driver.findElement(By.xpath("//h2"));
        System.out.println(thankYou.getText());

        WebElement thankYouDes = driver.findElement(By.xpath("//div[@class='complete-text']"));
        System.out.println(thankYouDes.getText());


















    }
}
