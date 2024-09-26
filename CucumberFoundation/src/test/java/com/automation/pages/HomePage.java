package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "search-keyword")
    WebElement searchBx;

    @FindBy(id = "dropdownMenuLink")
    WebElement cartIcon;


    public void openTheWebsite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean verifyHomePageIsDisplayed() {
        return isDisplay(searchBx) && isDisplay(cartIcon);
    }

    public void searchBox(String item) {
        searchBx.sendKeys(ConfigReader.getConfigValue(item));
    }

    public void clickOnSearchBtn() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(searchBx).keyDown(Keys.ENTER).build().perform();
    }
}
