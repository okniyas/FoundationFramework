package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens application")
    public void user_opens_application() {
        homePage.openApplication();
        
    }
    @When("user click on search button")
    public void userClickOnSearchButton() {
        homePage.clickOnSearchBtn();
    }

    @When("user search for item {string}")
    public void user_search_for_item(String itemKey) {
        homePage.userSearchForItem(ConfigReader.getConfigValue(itemKey));
        
    }
}
