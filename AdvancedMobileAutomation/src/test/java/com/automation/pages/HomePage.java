package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='search_default_search_text_input']")
    WebElement searchInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='search_autosuggest_product_click_0']")
    WebElement searchOption;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='PHOTO_SEARCH_1_2']/android.view.ViewGroup")
    WebElement pageLoader;

    public void openApplication() {
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public void userSearchForItem(String item) {
        isPresent(pageLoader);
        searchInput.sendKeys(item);
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        waitForElementToBeVisible(searchOption);
        searchOption.click();

    }


}
