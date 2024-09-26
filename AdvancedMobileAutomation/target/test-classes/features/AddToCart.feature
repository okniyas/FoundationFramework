Feature: Validate add to cart functionality

  Scenario: Verify user can add a product to cart successfully
    Given user opens application
    When user click on search button
    And user search for item "item.name.1"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed
    When user clicks add to cart button
    And select the size of item "item.size"
    And click on done button
    Then verify that item is added to cart