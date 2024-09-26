Feature: Validate post request

  Background:
    * def requestBody = read("classpath://json//create_employee.json")

  Scenario: Verify user can create employee
    Given url host
    And path '/create'
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And request requestBody
    When method post
    Then status 200
    And print response
