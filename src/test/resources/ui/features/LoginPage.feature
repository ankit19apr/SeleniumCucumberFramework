Feature: Login Functionality

  Background:
    Given user navigate to HomePage page
    When user click on login link
    And the user is on the login page

  Scenario Outline: Verify user log in with valid credentials
    When user enters valid "<email>" and "<password>" credentials
    Then user click login button

    Examples:
      | email                  | password |
      | bajoy99768@inikale.com | Pass123  |


  Scenario Outline: Verify user cannot log in with invalid credentials
    When user enters invalid "<email>" and "<password>" credentials
    And user click login button
    Then user should see an error message
    Examples:
      | email                  | password |
      | anotheruser@domain.com | Secret45 |