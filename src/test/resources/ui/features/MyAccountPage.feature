Feature: My Account Page Functionality

  Background:
    Given user navigate to HomePage page
    When user click on login link
    And the user is on the login page

  Scenario Outline: Verify user see username on My Account Page
    When user enters valid "<email>" and "<password>" credentials
    Then user click login button
    And user able to see user name on my account page

    Examples:
      | email                  | password |
      | bajoy99768@inikale.com | Pass123  |



