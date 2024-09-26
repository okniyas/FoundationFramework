package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductListPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-item ']//h4")
    WebElement firstProductTitle;

    @FindBy(xpath = "//div[contains(@class, 'category_page')]")
    WebElement categoryName;

    @FindBy(xpath = "//div/h1")
    WebElement productTitle;

    public static String itemNameAddedToCart;


    public boolean verifyOnProductListPage() {
        return isDisplay(firstProductTitle) && isDisplay(categoryName);
    }

    public void clickOnFirstProduct() {
        itemNameAddedToCart = firstProductTitle.getText();
        firstProductTitle.click();
    }
}
