Feature: Validate holidays functionality

  Scenario: Verify holidays search functionality
    Given user opens the website
    Then verify user is on home page
    When the user clicks on Holidays from the navigation bar
    Then verify the user is on the holidays home page
    When the user enters the destination "Kerala"
    And user select the destination from the dropdown list
    Then verify the holidays listing page shows results for the destination "Kerala"
