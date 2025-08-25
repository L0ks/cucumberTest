Feature: DemoQA elements page

  Scenario: Open Text Box element feature
    Given I open the Demo QA elements page
    When I click "Text Box" in the left panel
    Then the list contains the following options options:
      | Elements                |
      | Forms                   |
      | Alerts, Frame & Windows |
      | Widgets                 |
      | Interactions            |
      | Book Store Application  |