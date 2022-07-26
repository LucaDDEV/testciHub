Feature: Hello World

  Scenario: Computing sum of two number
    As a user When I add two number 10 and 20 I should see the sum 30

    When I launch iOS app
    And I choose to enter "10" and "20"
    When I tap on Compute Sum
    Then I should see the result "30"
