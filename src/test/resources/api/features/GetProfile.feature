Feature: Get User Profile API

  Scenario: Verify if Get Profile API is working
    Given the user logs in with username "dikeje123" and password "viraaj123"
    When the user sends a request to fetch their profile
    Then the API should return the username as "dikeje123"
    And the status code should be 200
