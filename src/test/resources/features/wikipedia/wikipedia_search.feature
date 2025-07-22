Feature: Wikipedia Search

  Scenario: Search for Selenium software
    Given I open the Wikipedia home page
    When I search for "Selenium"
    Then the first heading should be "Selenium"