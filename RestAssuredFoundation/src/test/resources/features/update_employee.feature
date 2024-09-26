Feature: Validate the put request

  Scenario: Verify user can update the employee by id
    Given user wants to call "/create" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_employee.json"
    When user performs post call
    Then verify status code is 200
    And verify employee id is not empty
    And store created employee id into "employee.id"
    When user wants to call "/update/@id" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "update_employee.json" using pojo
    And user performs put call
    Then verify status code is 200

#    hard coded
  Scenario: Verify user can update employee
    When user wants to call "/update/2" endpoint
    And set header "Content-Type" to "application/json"
    And set request body from the file "update_employee.json" using pojo
    And user performs put call
    Then verify status code is 200

