Feature: Validate product search functionality

  Scenario: Verify user can search for a product
    Given user opens application
    When user click on search button
    And user search for item "item.name.1"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed


  Scenario: Verify product listing page shows the searched item only
    Given user opens application
    When user click on search button
    And user search for item "item.name.1"
    And verify product listing page is displayed item using scroll