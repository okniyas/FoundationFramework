package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyUserCanAddProductToCart() {

        homePage.openTheWebsite();
        Assert.assertTrue(homePage.verifyHomePageIsDisplayed());
        homePage.clickOnAnySectionFromNavBar(ConfigReader.getConfigValue("section.name"));

        Assert.assertTrue(productListPage.verifyOnProductListPage());
        productListPage.clickOnFirstProduct();

        productPage.selectSize(ConfigReader.getConfigValue("select.size"));
        productPage.clickOnAddToBagBtn();
        productPage.clickOnCartIcon();

        cartPage.verifyCartContainsTheSameProduct();

    }
}
