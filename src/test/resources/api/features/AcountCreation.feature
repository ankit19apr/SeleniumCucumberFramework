Feature: Account Creation API

  Scenario: Verify if Account Creation API is working
    Given the user provides valid account creation details
    When the user sends a request to create an account
    Then the API should return a success message "User registered successfully!"
    And the status code should be 200
