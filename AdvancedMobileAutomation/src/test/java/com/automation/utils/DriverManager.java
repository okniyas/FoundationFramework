package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static AppiumDriver driver;

    public static void createDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
        capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
        capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
        capabilities.setCapability("app", ConfigReader.getConfigValue("app.path"));
        capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
        capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
        capabilities.setCapability("autoGrantPermissions", true);

        driver = new AppiumDriver(capabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
