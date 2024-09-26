package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens the website")
    public void user_opens_the_website() {
        homePage.openTheWebsite();
    }

    @Then("verify user on home page")
    public void verify_user_on_home_page() {
        Assert.assertTrue(homePage.verifyHomePageIsDisplayed());
    }

    @When("user search for {string}")
    public void user_search_for(String item) {
        homePage.searchBox(item);
    }

    @When("click on search button")
    public void click_on_search_button() {
        homePage.clickOnSearchBtn();
    }

}
