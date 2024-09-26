package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.nio.file.Paths;
import java.util.List;

public class ExpediaFlight {
    public static void main(String[] args) {
        String leavingCity = "Hyderabad";
        String destinationCity = "Delhi";
        String adultCount = "3";
        String childrenCount = "2";
        List<String> childrenAge = List.of("6", "3");

        String startDate = "21 September 2024";
        String endDate = "29 September 2024";


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/screenshot.png")));
        page.navigate("https://www.expedia.co.in/");

        Locator flightNavBar = page.locator("//span[text()='Flights']/parent::a");
        flightNavBar.click();

        Locator leavingFrom = page.locator("//button[@data-stid='origin_select-menu-trigger']");
        leavingFrom.click();

        Locator leavingFromInput = page.locator("input#origin_select");
        leavingFromInput.fill(leavingCity);

        Locator leavingFromOption = page.locator("//button[@data-stid='origin_select-result-item-button']").first();
        leavingFromOption.click();

        Locator leavingTo = page.locator("//button[@data-stid='destination_select-menu-trigger']");
        leavingTo.click();

        Locator leavingToInput = page.locator("input#destination_select");
        leavingToInput.fill(destinationCity);

        Locator leavingToOption = page.locator("//button[@data-stid='destination_select-result-item-button']").first();
        leavingToOption.click();

        Locator dateOption = page.locator("//button[@data-testid='uitk-date-selector-input1-default']");
        dateOption.click();

        startingAndEndingDate(startDate, page);
        startingAndEndingDate(endDate, page);

        Locator dateApply = page.locator("//button[@data-stid='apply-date-selector']");
        dateApply.click();

        Locator travellerDetails = page.locator("//button[@data-stid='open-room-picker']");
        travellerDetails.click();

        Locator adultElement = page.locator("//span[@class='uitk-step-input-label' and text()='Adults']/parent::label/following-sibling::div/input");
        Locator adultAdd = page.locator("//span[@class='uitk-step-input-label' and text()='Adults']/parent::label/following-sibling::div/button").last();
        System.out.println("adult attribute: " + adultElement.getAttribute("value"));
        while (!adultElement.getAttribute("value").equals(adultCount)) {
            adultAdd.click();
        }

        Locator childElement = page.locator("//span[@class='uitk-step-input-label' and text()='Children']/parent::label/following-sibling::div/input");
        Locator childAdd = page.locator("//span[@class='uitk-step-input-label' and text()='Children']/parent::label/following-sibling::div/button").last();
        System.out.println("child attribute: " + childElement.getAttribute("value"));
        while (!childElement.getAttribute("value").equals(childrenCount)) {
            childAdd.click();
        }

        String XPATH_CHILD_SELECTOR_AGE = "#age-traveler_selector_children_age_selector-%s";

        for (int i = 0; i < Integer.parseInt(childrenCount); i++) {
            String xpathChild = String.format(XPATH_CHILD_SELECTOR_AGE, i);
            System.out.println("child xpath: " + xpathChild);
            Locator selectTag = page.locator(xpathChild);

            selectTag.selectOption(new SelectOption().setValue(childrenAge.get(i)));
        }

        Locator travellersDoneBtn = page.locator("button#travelers_selector_done_button");
        travellersDoneBtn.click();

        Locator searchBtn = page.locator("button#search_button");
        searchBtn.click();




    }

    public static void startingAndEndingDate(String date, Page page) {

        String day = date.substring(0, date.indexOf(" "));
        String monthYear = date.substring(date.indexOf(" ") + 1);
//        String year = date.substring(date.lastIndexOf(" ") + 1);
        Locator monthYearElement = page.locator("//div[contains(@class, 'uitk-month-double-left')]/span");
        Locator nextMonthBtn = page.locator("//button[@data-stid='uitk-calendar-navigation-controls-next-button']");

        while (!monthYearElement.innerText().equalsIgnoreCase(monthYear)) {
            nextMonthBtn.click();
        }
        String XPATH_DAY = "//div[contains(@class, 'uitk-month-double-left')]//div[contains(@class, 'uitk-date-number') and text()='%s']";
        String xpath = String.format(XPATH_DAY, day);
        Locator dayElement = page.locator(xpath);

        dayElement.click();
    }
}
