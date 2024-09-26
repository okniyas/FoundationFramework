package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'addtobagbtn')]")
    WebElement addToBag;

    @FindBy(id = "dropdownMenuLink")
    WebElement cartIcon;

    String XPATH_ITEM_SIZE = "//span[@id='size-filter-input' and text()='%s']";

    public void selectSize(String size) {
        String xpath = String.format(XPATH_ITEM_SIZE, size);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickOnAddToBagBtn() {
        addToBag.click();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }
}
