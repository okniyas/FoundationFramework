package com.automation.listeners;

import com.automation.utils.ReportManager;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;

public class AllureListener extends AllureTestNg {
    @Override
    public void onTestFailure(ITestResult result) {
        ReportManager.attachScreenshot();
        ReportManager.attachLog("failed test case");
        super.onTestFailure(result);
    }
}
