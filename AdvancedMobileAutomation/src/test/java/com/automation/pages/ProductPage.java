package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='title_container']")
    WebElement productTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Add to Bag']")
    WebElement addToBag;

    String XPATH_FOR_SIZE_ITEM = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='buy_done_button']")
    WebElement doneAddToBagBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Go to Bag']")
    WebElement goToBagBtn;


    public boolean verifyProductPageIsDisplayed() {
        return isPresent(productTitle) && isPresent(addToBag);
    }

    public void clickOnAddToCartButton() {
        addToBag.click();
    }

    public boolean isVerifyItemIsAddedToCart() {

        return isPresent(goToBagBtn);
    }


    public void selectSizeOfTheItem(String size) {
        String sizeXpath = String.format(XPATH_FOR_SIZE_ITEM, size);
        driver.findElement(By.xpath(sizeXpath)).click();
    }

    public void clickOnDoneBtn() {
        waitForElementToBeClickable(doneAddToBagBtn);
        doneAddToBagBtn.click();
    }
}
