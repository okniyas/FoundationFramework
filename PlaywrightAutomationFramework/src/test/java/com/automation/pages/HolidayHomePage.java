package com.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HolidayHomePage extends BasePage {

    Locator holidayNavBar;
    Locator destinationSearchBx;
    Locator destinationDropdown;
    Locator holidaySearchBtn;

    public HolidayHomePage(){
        holidayNavBar = page.locator("//span[contains(@class, 'holidaymenuico')]");
        destinationSearchBx = page.locator("input#txtDesCity");
        destinationDropdown = page.locator("//ul[@ng-show='citytrue']/li//p").first();
        holidaySearchBtn = page.locator("button.subm_btn");

    }


    public void clickOnHolidaysFromNavBar() {
        holidayNavBar.click();
    }

    public Locator getDestinationSearchBx() {
        page.waitForLoadState(LoadState.LOAD);

//        page.waitForSelector("//ul[@ng-show='citytrue']/li//p", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE)).click();
        return destinationSearchBx;
    }

    public void enterTheDestination(String destination) {
        page.waitForLoadState(LoadState.LOAD);
        destinationSearchBx.fill(destination);
    }

    public void selectTheDestinationFromDropDownList() {

        page.waitForSelector("//ul[@ng-show='citytrue']/li//p", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE)).click();

    }
}
