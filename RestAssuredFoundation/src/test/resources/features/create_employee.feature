Feature: Validate post request

  Scenario: Verify user can create employee
    Given user wants to call "/create" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_employee.json"
    When user performs post call
    Then verify status code is 200
