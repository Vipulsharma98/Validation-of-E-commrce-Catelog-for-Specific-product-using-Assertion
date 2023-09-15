Feature: Access a Product via category after applying multiple filters

  Scenario: Access a Product via category after applying multiple filters
    Given user navigates to ebay
    Then user clicks on Shop by category
    And user clicks on Cell Phones & accessories
    And user clicks on Cell Phones & Smartphones
    And user clicks on See all under Shop by Brand
    And user Add filters
    And user clicks on Apply button
    Then user Verifies that the filter tags are applied

  Scenario: Access a Product via Search
    Given user navigates to ebay
    Then user type "MacBook" in the search bar
    And user change categories to Computers Tablets and Networking
    And user clicks on search button
    And user should see page load completely with name "Computers"
    And user should see first search result name matches with "MacBook"
