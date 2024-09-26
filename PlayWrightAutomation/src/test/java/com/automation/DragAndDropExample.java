package com.automation;

import com.microsoft.playwright.*;

import java.util.List;

public class DragAndDropExample {
    public static void main(String[] args)  {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://www.globalsqa.com/demo-site/draganddrop/");

        FrameLocator iframe = page.frameLocator("//iframe[contains(@class, 'demo-frame')]").first();
        List<Locator> images = iframe.locator("//ul[@id='gallery']/li").all();
        Locator target = iframe.locator("div#trash");
        Locator image;
        for(int i=0; i<images.size();i++){
            image = iframe.locator("//ul[@id='gallery']/li").first();
            image.dragTo(target);
            page.waitForTimeout(2000);
        }

        playwright.close();
    }
}
