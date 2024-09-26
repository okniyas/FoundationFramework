package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductListPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-item ']//h4")
    WebElement firstProductTitle;

    @FindBy(xpath = "//div[contains(@class, 'category_page')]//span")
    WebElement categoryName;

    @FindBy(xpath = "//div/h1")
    WebElement productTitle;


    public boolean verifyOnProductListPage() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(firstProductTitle));

        return isDisplay(firstProductTitle) && isTextDisplayed(categoryName, ConfigReader.getConfigValue("item.name"));
    }

    public void clickOnFirstProduct() {
        firstProductTitle.click();
    }

    public boolean verifyProductTitleContainsSearchItem() {
        return isTextDisplayed(productTitle, ConfigReader.getConfigValue("item.name"));
    }
}
