Feature: Home page


  Scenario: Verify user able to land on the Home page successfully

    Given user navigate to HomePage page
    When user should be able to view the Home Page UI with web elements
      | Home Page Logo   |
      | View My Cart   |
      | Search Text Box         |
      | Login Link       |
      | Contact Us Link          |
    Then user click on login link

