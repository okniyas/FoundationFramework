package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@class='itemContainer-base-details']//a")
    WebElement productNameInCart;


    public void verifyCartContainsTheSameProduct(){
        Assert.assertEquals(productNameInCart.getText(), ProductListPage.itemNameAddedToCart);
    }
}
