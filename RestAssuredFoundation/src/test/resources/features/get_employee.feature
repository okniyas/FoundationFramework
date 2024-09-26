Feature: Validate the get request

  Scenario: Verify user can get the list of employees
    Given user wants to call "/employees" endpoint
    When user performs get call
    Then verify status code is 200

  Scenario: Verify user can get the employee by id
    Given user wants to call "/create" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_employee.json"
    When user performs post call
    Then verify status code is 200
    And verify employee id is not empty
    And store created employee id into "employee.id"
    When user wants to call "/employee/@id" endpoint
    And user performs get call
    Then verify status code is 200

#  hard coded
  Scenario: Verify user can get the employee
    Given user wants to call "/employee/4" endpoint
    When user performs get call
    Then verify status code is 200