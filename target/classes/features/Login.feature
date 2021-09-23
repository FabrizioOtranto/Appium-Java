Feature: Login

  Scenario: The user can login
    Given the APP
    Given Enter Username
    And click SignIn
    Given Enter Password
    When click SignInAgain
    Then Login successfully

