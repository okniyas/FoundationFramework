Feature: Validate delete request

  Scenario: Verify user can delete the employee by id
    Given user wants to call "/create" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_employee.json"
    When user performs post call
    Then verify status code is 200
    And verify employee id is not empty
    And store created employee id into "employee.id"
    When user wants to call "/delete/@id" endpoint
    And user performs delete call
    Then verify status code is 200

#    hard coded
  Scenario: Verify user can delete the employee
    Given user wants to call "/delete/5" endpoint
    And user performs delete call
    Then verify status code is 200