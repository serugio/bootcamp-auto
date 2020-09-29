@ESPNTests
Feature: createAccount

  Background:
    Given user enters to espn page

  @tc-001  @createAccount
  Scenario: create account successfully
    When user clicks user icon
    And user clicks log In button
    Then user clicks signUp button
    Then user fills create account form
    And user clicks signUp modal button
    Then account it's created successfully

