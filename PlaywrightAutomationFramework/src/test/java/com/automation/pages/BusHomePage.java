package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

public class BusHomePage extends BasePage {

    String XPATH_DAY = "//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']/a[contains(text(), '%s')]";

    Locator homeSearchBtn;
    Locator busNavBar;
    Locator busTicketText;
    Locator sourceCityInput;
    Locator destinationCityInput;
    Locator dateInput;
    Locator dateMonth;
    Locator dateYear;
    Locator nextMonth;
    Locator destinationCityOption;
    Locator sourceCityOption;
    Locator searchBtnBus;

    public BusHomePage() {
        homeSearchBtn = page.locator("button.srchBtnSe");
        busNavBar = page.locator("//span[contains(@class, 'busmenuico')]");
        busTicketText = page.locator("//h1");
        sourceCityInput = page.getByPlaceholder("Source City");
        sourceCityOption = page.locator("//ul[@id='srcNav']/li").first();
        destinationCityOption = page.locator("//ul[@id='desNav']/li").first();
        destinationCityInput = page.getByPlaceholder("Destination City");
        dateInput = page.getByPlaceholder("dd-mm-yyyy");
        dateYear = page.locator("span.ui-datepicker-year");
        dateMonth = page.locator("span.ui-datepicker-month");
        nextMonth = page.locator("//a[@data-handler='next']");
        searchBtnBus = page.locator("input#srcbtn");


    }


    public void openWebsite() {
        page.navigate(ConfigReader.getConfigValue("application.url"));
    }

    public Locator getHomeSearchBtn() {
        return homeSearchBtn;
    }

    public void clickOnBusFromNavBar() {
        busNavBar.click();
    }

    public Locator getBusTicketText() {
        page.waitForLoadState(LoadState.LOAD);
        return busTicketText;
    }

    public void enterTheSourceCity(String sourceCity) {
        sourceCityInput.fill(sourceCity);
        sourceCityOption.click();
    }

    public void enterTheDestinationCity(String destinationCity) {
        destinationCityInput.fill(destinationCity);
        destinationCityOption.click();
    }

    public void selectDepartureDate(String date) {
        dateInput.click();

        String yearInput = date.substring(date.lastIndexOf(" ") + 1);
        String monthInput = date.substring(date.indexOf(" ") + 1, date.lastIndexOf(" "));
        String dayInput = date.substring(0, date.indexOf(" "));

        while (!dateYear.textContent().equals(yearInput)) {
            nextMonth.click();
//            dateYear = page.locator("span.ui-datepicker-year");
        }
        while (!dateMonth.textContent().equals(monthInput)) {
            nextMonth.click();
//            dateMonth = page.locator("span.ui-datepicker-month");
        }
        String dayXpath = String.format(XPATH_DAY, dayInput);
        page.locator(dayXpath).click();
    }

    public void clickOnSearchBtnOnBusPage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchBtnBus.click();
    }


}
