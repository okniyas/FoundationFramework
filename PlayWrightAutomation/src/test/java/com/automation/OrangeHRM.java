package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class OrangeHRM {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        BrowserContext context1 = browser.newContext();
        Page page = context1.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Locator usernameInput = page.getByPlaceholder("Username");
        Locator passwordInput = page.getByPlaceholder("Password");
        Locator loginBtn = page.locator("//button");

        usernameInput.fill("Admin");
        passwordInput.fill("admin123");

//        page.waitForLoadState(LoadState.LOAD);

        page.screenshot(new Page
                .ScreenshotOptions()
                .setMask(List.of(usernameInput))
                .setPath(Paths.get("./target/screenshot.png")));

        loginBtn.click();


        Page samePageTab = context1.newPage();
        samePageTab.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Locator userDropdown = samePageTab.locator("//li[@class='oxd-userdropdown']");
        assertThat(userDropdown).isVisible();


        BrowserContext context2 = browser.newContext();
        Page newTab = context2.newPage();

        newTab.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Locator usernameNewTabInput = newTab.getByPlaceholder("Username");
        Locator passwordNewTabInput = newTab.getByPlaceholder("Password");

        assertThat(usernameNewTabInput).isVisible();
        assertThat(passwordNewTabInput).isVisible();


    }
}
