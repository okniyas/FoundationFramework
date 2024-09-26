package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListingPage extends BasePage {

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'plp_product')]")
    List<WebElement> listOfItems;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'plp_product')]")
    WebElement itemContainer;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search']//ancestor::android.view.ViewGroup[3]")
    WebElement headerContainer;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'plp_product')]")
    List<String> listOfItemsByScroll;

    @FindBy(xpath = "//android.widget.TextView[@text='GENDER']")
    WebElement genderOption;

    String XPATH_FOR_GENDER_CATEGORY = "//android.widget.TextView[@text='%s']";

    String XPATH_FOR_GENDER = "//android.view.ViewGroup[@content-desc='view_bottom_filter']//android.widget.TextView[@text='%s']";


    public boolean isVerifySearchResultsNotEmpty() {
        return !listOfItems.isEmpty();
    }

    public void clickOnFirstProduct() {
        listOfItems.get(0).click();
    }


    public boolean verifyProductListingIsDisplayedItemsUsingScroll() {
        int headerY = headerContainer.getLocation().getY();
        int heightHeader = headerContainer.getSize().getHeight();

        int x = itemContainer.getLocation().getX();
        int y = itemContainer.getLocation().getY();
        int width = itemContainer.getSize().getWidth();
        int height = itemContainer.getSize().getHeight();

        scrollOrSwipe((x + width) / 2, y, (x + width) / 2, headerY + heightHeader);
        int item = 1;
        int ele;
        WebElement textElement;
        while (item <= 5) {
            itemContainer = driver.findElement(By.xpath("//android.view.ViewGroup[contains(@content-desc,'plp_product')]"));
            x = itemContainer.getLocation().getX();
            y = itemContainer.getLocation().getY();
            width = itemContainer.getSize().getWidth();
            height = itemContainer.getSize().getHeight();

            for (int i = 0; i < 2; i++) {
                ele = i + 1;
                textElement = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc='text_brand'])[" + ele + "]"));
                System.out.println(textElement.getText());
                listOfItemsByScroll.add(textElement.getText());
            }
            scrollOrSwipe((x + width) / 2, y + height, (x + width) / 2, headerY + heightHeader);
            item++;

        }
        return !listOfItemsByScroll.isEmpty();
    }

    public void clickOnGenderOption() {
        genderOption.click();
    }

    public void selectCategoryType(String genderCategory) {
        String genderXpath = String.format(XPATH_FOR_GENDER_CATEGORY, genderCategory);
        driver.findElement(By.xpath(genderXpath)).click();

    }

    public boolean verifyGenderOptionIsChanged(String genderCategory) {
        String genderXpath = String.format(XPATH_FOR_GENDER, genderCategory.toUpperCase());
//        driver.findElement(By.xpath(genderXpath)).isDisplayed();
        return isPresent(driver.findElement(By.xpath(genderXpath)));

    }
}
