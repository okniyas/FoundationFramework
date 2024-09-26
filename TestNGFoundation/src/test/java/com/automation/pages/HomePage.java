package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "search-keyword")
    WebElement searchBx;

    @FindBy(id = "dropdownMenuLink")
    WebElement cartIcon;

    String XPATH_SECTION = "//div[@class='Menus_navigationMain__sc9oG']//a[text()='%s']";



    public void openTheWebsite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean verifyHomePageIsDisplayed() {
        return isDisplay(searchBx) && isDisplay(cartIcon);
    }

    public void clickOnAnySectionFromNavBar(String section) {
        String xpath = String.format(XPATH_SECTION, section);
        driver.findElement(By.xpath(xpath)).click();
    }


}
