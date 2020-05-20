@regression
Feature: Login API

  Scenario: Login with valid credential
    Then User verify with valid credentials

  Scenario: Login with invalid credential
    Then User verify with invalid credentials "random@gmail.com" "random"

