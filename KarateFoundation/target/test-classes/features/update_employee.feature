Feature: Validate the put request

  Background:
    * def requestBody = read("classpath://json//update_employee.json")

  Scenario: Verify user can update the employee by id
    * def createEmployeeResponse = call read("classpath://features//create_employee.feature")

    Given url host
    And path '/update/'+createEmployeeResponse.response.data.id
    And header Content-Type = 'application/json'
    And request requestBody
    When method put
    Then status 200
    And print response

#    hard coded
  Scenario: Verify user can update the employee
    Given url host
    And path '/update/4'
    And header Content-Type = 'application/json'
    And request requestBody
    When method put
    Then status 200
    And print response
