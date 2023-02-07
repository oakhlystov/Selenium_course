Feature: LoginFeature
  This login feature allows us to check if we can log in

  Scenario: Login with correct login and password
    Given I navigate to login page
    And I enter the username as admin and password as admin
    And I click login button
    Then I should see the userform page