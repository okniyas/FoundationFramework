package com.automation.steps;

import com.automation.pojo.EmployeePojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class RequestSteps {

    @Given("user wants to call {string} endpoint")
    public void user_wants_to_call_endpoint(String endPoint) {
        if(endPoint.contains("@id")){
            endPoint = endPoint.replace("@id", ConfigReader.getConfigValue("employee.id"));
        }
        RestAssuredUtils.setEndPoint(endPoint);
        
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
        
    }

    @Given("set request body from the file {string}")
    public void set_request_body_from_the_file(String fileName) {
        RestAssuredUtils.setBody(fileName);
        
    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();
        
    }


    @When("user performs get call")
    public void userPerformsGetCall() {
        RestAssuredUtils.get();
    }

    @And("user performs put call")
    public void userPerformsPutCall() {
        RestAssuredUtils.put();
    }

    @And("set request body from the file {string} using pojo")
    public void setRequestBodyFromTheFileUsingPojo(String fileName) throws JsonProcessingException {

        String jsonFolderPath = ConfigReader.getConfigValue("json.folder.path");
        String jsonBody = RestAssuredUtils.getDataFromFile(jsonFolderPath + fileName);

        ObjectMapper om = new ObjectMapper();
        EmployeePojo employeePojo = om.readValue(jsonBody, EmployeePojo.class);

        RestAssuredUtils.setBodyUsingPojo(employeePojo);
    }

    @And("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredUtils.delete();
    }
}
