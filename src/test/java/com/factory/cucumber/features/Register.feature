@regression
Feature: Register API

  Scenario: Register without data
    Then User verify error empty data

  Scenario: Register with existed data
    Then User verify error existed data

  Scenario: Register with data
    Then User verify successful create user

