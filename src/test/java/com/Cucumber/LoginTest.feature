Feature: Login

  Scenario: Verify Login with Invalid Credentials
    Given Open Browser and Navigate to Login page
    When Enter Email and Password
    Then Login UnSuccessful and Close Test