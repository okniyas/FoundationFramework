package com.automation.pages;


import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

public class BusListingPage extends BasePage {

    Locator busDetails;

    public BusListingPage() {
    }

    public Locator getBusDetails() {

//        page.locator("div.bus-detail").first().waitFor(new Locator.WaitForOptions().setTimeout(30000)); // Example: 10 seconds timeout
        page.waitForSelector("div.bus-detail", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        return busDetails = page.locator("div.bus-detail").first();
    }

    public boolean isVerifyUserOnListingPageOfBus() {
        page.waitForSelector("div.bus-detail", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        List<Locator> listOfBuses = page.locator("div.bus-detail").all();
//        Locator selectSeatBtn = page.locator("myBtn").first();

        System.out.println(listOfBuses.size()+ " list");
//        System.out.println(selectSeatBtn.isVisible()+ " visible");
        return listOfBuses.size() > 0;
    }
}
