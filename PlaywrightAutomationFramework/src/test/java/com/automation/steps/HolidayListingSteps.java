package com.automation.steps;

import com.automation.pages.HolidayListingPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.Then;


public class HolidayListingSteps {

    HolidayListingPage holidayListingPage = new HolidayListingPage();

    @Then("verify the holidays listing page shows results for the destination {string}")
    public void verify_the_holidays_listing_page_shows_results_for_the_destination(String destination) {
        assertThat(holidayListingPage.getDestinationHeadTag()).containsText(destination);
        assertThat(holidayListingPage.getPackageBtn()).isVisible();
    }
}
