Feature: Calculate rate

  Background:
    Given I set up mock User data for application


  Scenario: Get the Loan Calculator
    When I navigate to Get a Zopa loan
    And I navigate to Get my personalised rates
    And I fill the application form with random data
