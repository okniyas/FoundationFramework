package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import io.cucumber.java.*;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initConfig();
        DriverManager.createDriver();
        CucumberReportManager.initReport(scenario);
        ExtentReportManager.createTest(scenario.getName());
    }


    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManager.attachScreenShot();
            CucumberReportManager.attachScreenShot();
            ExtentReportManager.getExtentTest().fail(scenario.getName() + " Failed");

        }
        DriverManager.getDriver().quit();
    }

    @BeforeAll
    public static void setUpAll() {
        ExtentReportManager.initExtentReport();
    }

    @AfterAll
    public static void cleanUpAll() {
        ExtentReportManager.flush();
    }
}
