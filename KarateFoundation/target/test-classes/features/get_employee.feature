Feature: Validate the get request

  Scenario: Verify user can get the list of employees
    Given url host
    And path '/employees'
    When method get
    Then status 200
    And print response


  Scenario: Verify user can get the employee by id
    * def createEmployeeResponse = call read("classpath://features//create_employee.feature")

    Given url host
    And path '/employee/'+createEmployeeResponse.response.data.id
    When method get
    Then status 200
    And print response

#    hard coded
  Scenario: Verify user can get the employee
    Given url host
    And path '/employee/5'
    When method get
    Then status 200
    And print response
