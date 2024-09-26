package com.automation.steps;

import com.automation.pages.ProductListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListSteps {

    ProductListPage productListPage = new ProductListPage();

    @Then("verify user on product list page")
    public void verify_user_on_product_list_page() {
        Assert.assertTrue(productListPage.verifyOnProductListPage());
    }

    @When("user click on first product")
    public void user_click_on_first_product() {
        productListPage.clickOnFirstProduct();
    }

    @Then("verify product title contains the search item {string}")
    public void verify_product_title_contains_the_search_item(String item) {
        Assert.assertTrue(productListPage.verifyProductTitleContainsSearchItem());
    }
}
