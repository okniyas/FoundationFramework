package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());

    }

    @And("verify employee id is not empty")
    public void verifyEmployeeIdIsNotEmpty() {
        String employeeId = RestAssuredUtils.getResponseValue("data.id");
        Assert.assertTrue(!employeeId.isEmpty());
    }

    @And("store created employee id into {string}")
    public void storeCreatedEmployeeIdInto(String key) {
        ConfigReader.setConfigValue(key, RestAssuredUtils.getResponseValue("data.id"));

    }
}
