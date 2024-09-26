package com.automation.steps;

import com.automation.pages.ProductListingPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductListingSteps {

    ProductListingPage productListingPage = new ProductListingPage();

    @Then("verify search results is not empty")
    public void verify_search_results_is_not_empty() {
        Assert.assertTrue(productListingPage.isVerifySearchResultsNotEmpty());
    }

    @Then("click on the first result")
    public void click_on_the_first_result() {
        productListingPage.clickOnFirstProduct();

    }

    @Then("verify product listing page is displayed item using scroll")
    public void verifyProductPageIsDisplayedItemUsingScroll() {
        Assert.assertTrue(productListingPage.verifyProductListingIsDisplayedItemsUsingScroll());
    }

    @And("click on the gender option")
    public void clickOnTheGenderOption() {
        productListingPage.clickOnGenderOption();
    }

    @And("select category as {string}")
    public void selectCategoryAs(String categoryKey) {
        productListingPage.selectCategoryType(ConfigReader.getConfigValue(categoryKey));
    }


    @Then("verify the gender option is changed to {string}")
    public void verifyTheGenderOptionIsChangedTo(String genderKey) {
        Assert.assertTrue(productListingPage.verifyGenderOptionIsChanged(ConfigReader.getConfigValue(genderKey)));
    }
}
