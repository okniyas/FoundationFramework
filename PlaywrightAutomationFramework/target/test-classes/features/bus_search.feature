Feature: Validate bus functionalities

  Scenario: Verify bus booking
    Given user opens the website
    Then verify user is on home page
    When the user clicks on Bus from the navigation bar
    Then verify the user is on the bus home page
    When user enter the source city "Bangalore"
    And user enter the destination city "Hyderabad"
    And user select departure date as "10 September 2024"
    And user click on search button on the bus page
    Then verify user is on listing page of the bus page


