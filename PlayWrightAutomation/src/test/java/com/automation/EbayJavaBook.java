package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

public class EbayJavaBook {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://www.ebay.com/");

        Locator advancedOption = page.locator("a#gh-as-a");
        advancedOption.click();

        Locator keyword = page.locator("input#_nkw");
        keyword.fill("java");

        Locator category = page.locator("//label[text()='In this category']/parent::div//select");

//        Locator bookMagazine = page.locator("//label[text()='In this category']/parent::div//select/option[text()='Books & Magazines']");

        category.selectOption(new SelectOption().setValue("267"));
//        page.getByLabel("value").selectOption("267");
        Locator startPrice = page.locator("//input[@name='_udlo']");
        Locator endPrice = page.locator("//input[@name='_udhi']");

        startPrice.fill("0");
        endPrice.fill("100");

        Locator condition = page.locator("//label[text()='New']");
        condition.click();

        Locator availableTo = page.locator("//label[text()='Available to ']/following-sibling::span//select");
        availableTo.selectOption(new SelectOption().setValue("95"));

        Locator searchBtn = page.locator("//button[text()='Search']").last();
        searchBtn.click();

        Locator firstItem = page.locator("//div[@id='srp-river-main']//ul/li[@id]//div[@class='s-item__title']").first();
//        firstItem.click();

//        Page newPageTab = page.context().waitForPage(firstItem::click);
//        Page newPageTab = page.context().waitForPage(() -> firstItem.click());
        Page newPageTab = page.waitForPopup(() -> firstItem.click());

        // Interact with the new page normally
        Locator price = newPageTab.locator("//div[@id='mainContent']//div[@data-testid='x-price-primary']/span");
        System.out.println(price.innerText());

        newPageTab.close();

//        firstItem = page.locator("//div[@id='srp-river-main']//ul/li[@id]//div[@class='s-item__title']").first();
//        System.out.println(firstItem.innerText());


        playwright.close();
        System.out.println("Execution over");
    }


}
