Feature: As a user
  I should be able to login

  @validlogin
  Scenario: Validate user is able to login with valid credentials

    Given I am on home page
    When I click on the Sign in button
    And I enter the username "<username>"
    And I click next to enter the password
    And I enter the password "<password>"
    And I click next button to sign in
    Then I reach my yahoo home page


    @invalidlogin
    Scenario Outline: Validate user is able to login with invalid username

      Given I am on home page
      When I click on the Sign in button
      And I enter invalid username "<username>"
      And I click next to enter the password
      Then I should see error message "Sorry, we don't recognise this email address."
    Examples:
      |username|
      |SecondTestLogin|
      |ThirdTestLogin|

