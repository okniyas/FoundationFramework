package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ActionsExample {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://www.ebay.com/");

        //hover
        page.locator("//li/a[text()='Electronics']").hover();

        Thread.sleep(2000);

        //role
        page.getByRole(AriaRole.COMBOBOX).first().fill("Laptop");
        page.locator("#gh-btn").click();

        //label
//        page.getByLabel("Search for anything").fill("Laptop");
//        page.locator("#gh-btn").click();

        Locator advancedOption = page.getByLabel("Advanced Search");
        advancedOption.click();

        Locator keyword = page.locator("input#_nkw");
        keyword.fill("laptop");


        //select
        Locator category = page.locator("//label[text()='In this category']/parent::div//select");
        category.selectOption(new SelectOption().setValue("58058"));

        //checkbox
        page.locator("[name='LH_TitleDesc']").check();

        Locator startPrice = page.getByLabel("Enter minimum price range value, $");
        Locator endPrice = page.getByLabel("Enter maximum price range value, $");

        startPrice.fill("0");
        endPrice.fill("100");

        //Buying format
        page.locator("[value='LH_BIN']").setChecked(true);


        Locator condition = page.locator("//label[text()='New']");
        condition.click();

        //show results option
        page.locator("[name='LH_FR']").setChecked(true);
        page.locator("[name='LH_RPA']").check();
        Thread.sleep(5000);
//        page.locator("[name='LH_AS']").check();


        Locator availableTo = page.locator("//label[text()='Available to ']/following-sibling::span//select");
        availableTo.selectOption("India");

        Locator sorting = page.getByLabel("Sort By");
        sorting.selectOption(new SelectOption().setValue("15"));

        Locator searchBtn = page.getByText("Search").last();
        searchBtn.press("Enter");

        Locator firstItem = page.locator("//div[@id='srp-river-main']//ul/li[@id]//div[@class='s-item__title']").first();

//        Page newPageTab = page.context().waitForPage(firstItem::click);
//        Page newPageTab = page.context().waitForPage(() -> firstItem.click());
        Page newPageTab = page.waitForPopup(() -> firstItem.click());


        // Interact with the new page
        Locator price = newPageTab.locator("//div[@id='mainContent']//div[@data-testid='x-price-primary']/span");
        System.out.println(price.innerText());

        page.getByRole(AriaRole.CONTENTINFO).scrollIntoViewIfNeeded();



//        price.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
//        page.locator("//img[@data-idx='2']/parent::button").hover();
//        Thread.sleep(5000);

        newPageTab.close();

        playwright.close();
        System.out.println("Execution over");
    }
}
