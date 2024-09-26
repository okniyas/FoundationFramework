package com.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportManager {

    static Scenario scenario;

    public static void initReporter(Scenario scenario) {
        ReportManager.scenario = scenario;
    }

    public static void attachScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
    }

    public static void attachLog(String message) {
        scenario.log(message);
    }
}
