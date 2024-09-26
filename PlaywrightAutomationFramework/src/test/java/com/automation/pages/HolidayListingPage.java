package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;


public class HolidayListingPage extends BasePage {
    Locator packageBtn;
    Locator destinationHeadTag;

    public HolidayListingPage() {
        packageBtn = page.locator("//div[@class='listpnl']/div//a[text()='View Package  ']").first();
        destinationHeadTag = page.locator("//div[@class='bannerInr']/h1");
    }

    public Locator getDestinationHeadTag() {
        page.waitForSelector("//div[@class='bannerInr']/h1", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        return destinationHeadTag;
    }

    public Locator getPackageBtn() {
//        page.waitForSelector("//div[@class='listpnl']/div//a[text()='View Package  ']", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        return packageBtn;
    }
}
