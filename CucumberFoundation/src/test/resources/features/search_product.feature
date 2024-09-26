Feature: Validate search functionality

  Scenario: Verify user can search item and show the exact result
    Given user opens the website
    Then verify user on home page
    When user search for "item.name"
    And click on search button
    Then verify user on product list page
    When user click on first product
    Then verify product title contains the search item "item.name"