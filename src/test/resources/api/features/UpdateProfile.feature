Feature: Update User Profile

  Scenario: Verify user can update their profile information successfully
    Given the user logs in with username "dikeje123" and password "viraaj123"
    When the user retrieves their profile information
    Then the username in the profile should be "dikeje123"
    When the user updates their profile with first name "Kklem", last name "Mojo", email "xipepo1298@matmayer.com", and mobile number "6314186202"
    Then the profile should be updated with first name "Kklem", last name "Mojo", email "xipepo1298@matmayer.com", and mobile number "6314186202"
