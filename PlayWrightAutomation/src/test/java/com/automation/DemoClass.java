package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DemoClass {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");

        Locator usernameInput = page.locator("#user-name");
        Locator passwordInput = page.locator("#password");
        Locator loginBtn = page.locator("#login-button");

        usernameInput.fill("standard_user");
        passwordInput.fill("secret_sauce");
        loginBtn.click();

        assertThat(page.locator("span.title")).hasText("Products");

        List<Locator> items = page.locator("//div[@data-test='inventory-item-price']").all();
        for(Locator each : items){
            System.out.println(each.innerText());
        }

        Locator addToCart = page.locator("//div[@data-test='inventory-item']//button").first();
        addToCart.click();

        page.locator("a.shopping_cart_link").click();

        assertThat(page.locator("div.cart_item")).hasCount(1);

        Locator checkout = page.locator("#checkout");

        checkout.click();

        assertThat(page.locator("#first-name")).isVisible();
        assertThat(page.locator("#last-name")).isVisible();

        Locator firstNameInput = page.locator("#first-name");
        Locator lastNameInput = page.locator("#last-name");
        Locator pinCodeInput = page.locator("#postal-code");
        Locator continueBtn = page.locator("input#continue");

        firstNameInput.fill("test");
        lastNameInput.fill("by");
        pinCodeInput.fill("454545");
        continueBtn.click();

        assertThat(page.locator("//div[@data-test='payment-info-label']")).hasText("Payment Information:");

        System.out.println("price checkout: "+ page.locator("//div[@data-test='inventory-item-price']").innerText());

        System.out.println("Total after tax: "+page.locator("//div[@data-test='total-label']").innerText());

        page.locator("button#finish").click();

        assertThat(page.locator("//h2[@data-test='complete-header']")).isVisible();
        assertThat(page.locator("button#back-to-products")).isVisible();
        System.out.println("order confirm page: "+ page.locator("//h2[@data-test='complete-header']").innerText());


        playwright.close();
        System.out.println("Execution done");

    }
}
