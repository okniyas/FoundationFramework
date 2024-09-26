package com.automation;

import com.microsoft.playwright.*;

public class AlertsExample {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
//        Thread.sleep(2000);
//        Locator js = page.getByText("Click for JS Alert");
//        js.click();
//        Thread.sleep(2000);
//
//        page.onDialog(Dialog::accept);
//        Thread.sleep(2000);
//
//        page.getByText("Click for JS Confirm").click();
//        page.onDialog(Dialog::accept);
//
//        page.getByText("Click for JS Prompt").click();
//
//        page.onDialog(dialog -> dialog.accept("Hi user"));

        // Set up a single dialog handler
        page.onDialog(dialog -> {
            System.out.println("Dialog message: " + dialog.message());

            if (dialog.type().equals("alert")) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                dialog.accept();
                // Accept an alert dialog
            } else if (dialog.type().equals("confirm")) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                dialog.accept();
            } else if (dialog.type().equals("prompt")) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                dialog.accept("Hello I am here");
            }
        });


        page.locator("//button[text()='Click for JS Confirm']").click();
        page.waitForTimeout(2000);


        page.locator("//button[text()='Click for JS Alert']").click();
        page.waitForTimeout(2000);


        page.locator("//button[text()='Click for JS Prompt']").click();
        page.waitForTimeout(2000);


        playwright.close();

    }
}
