package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @Then("verify product page is displayed")
    public void verify_product_page_is_displayed() {
        Assert.assertTrue(productPage.verifyProductPageIsDisplayed());

    }

    @When("user clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
        productPage.clickOnAddToCartButton();

    }

    @Then("verify that item is added to cart")
    public void verify_that_item_is_added_to_cart() {
        Assert.assertTrue(productPage.isVerifyItemIsAddedToCart());

    }

    @And("select the size of item {string}")
    public void selectTheSizeOfItem(String sizeKey) {
        productPage.selectSizeOfTheItem(ConfigReader.getConfigValue(sizeKey));
    }

    @And("click on done button")
    public void clickOnDoneButton() {
        productPage.clickOnDoneBtn();
    }
}
