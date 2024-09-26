Feature: Validate delete request

  Scenario: Verify user can delete the employee by id
    * def createEmployeeResponse = call read("classpath://features//create_employee.feature")

    Given url host
    And path '/delete/'+createEmployeeResponse.response.data.id
    When method delete
    Then status 200
    And print response

  Scenario: Verify user can delete the employee
    Given url host
    And path '/delete/7'
    When method delete
    Then status 200
    And print response