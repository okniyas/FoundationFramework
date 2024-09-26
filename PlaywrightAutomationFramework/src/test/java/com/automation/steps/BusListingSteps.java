package com.automation.steps;

import com.automation.pages.BusListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class BusListingSteps {

    BusListingPage busListingPage = new BusListingPage();

    @Then("verify user is on listing page of the bus page")
    public void verify_user_is_on_listing_page_of_the_bus_page() {
//        assertThat(busListingPage.getBusDetails()).isVisible();
        Assert.assertTrue(busListingPage.isVerifyUserOnListingPageOfBus());
    }
}
