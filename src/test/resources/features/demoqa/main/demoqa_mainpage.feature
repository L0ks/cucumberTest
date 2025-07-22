Feature: DemoQA home page

  Scenario: Check available options on Demo QA main page
    Given I open the Demo QA home page
    When I see a list of category cards
    Then the list contains the following options options:
      | Elements                |
      | Forms                   |
      | Alerts, Frame & Windows |
      | Widgets                 |
      | Interactions            |
      | Book Store Application  |