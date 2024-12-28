Feature: Forgot Password API

  Scenario: Verify if Forgot Password API is working
    Given the user provides a valid email address "dikeje5082@gholar.com"
    When the user sends a request to reset the password
    Then the API should return a success message for forgot password "If your email exists in our system, you will receive reset instructions."
    And the status code should be 200
