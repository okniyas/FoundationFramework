Feature: Validate filter functionality

  Scenario Outline: Verify user can filter successfully
    Given user opens application
    When user click on search button
    And user search for item "<item_type>"
    Then verify search results is not empty
    And click on the gender option
    And select category as "gender.category"
    Then verify the gender option is changed to "gender.category"

    Examples:
      | item_type   |
      | item.name.2 |
      | item.name.3 |
      | item.name.4 |
      | item.name.5 |
