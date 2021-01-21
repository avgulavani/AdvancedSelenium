@Regression @browsertest
Feature: Reset functionality on login page of Application

  Scenario: Test login method
    Given Open and launch the application
    When I enter <input> in <fieldValue>
      | input      | fieldValue | fielType |
      | username12 | uid        | text     |
      | pw1        | password   | text     |
      | username13 | uid        | text     |
      | pw2        | password   | text     |
    Then Reset the credential
