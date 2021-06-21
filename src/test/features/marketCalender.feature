Feature: As a user
  I should be able to view the Finance Market Calendar

  @calendar
  Scenario: Validate user is able to view the Finance Market Calendar

    Given I am on home page
    When I click on the Sign in button
    And I enter the username "FirstTestLogin_12"
    And I click next to enter the password
    And I enter the password "TestAbc_12!"
    And I click next button to sign in
    And I reach my yahoo home page
    And I click on the menu Finance
    And I mouse hover over Market Data
    And I click on the sub menu Calendar
    And I scroll down the window
    And I click on next
    Then I can view the Finance Market Calendar