@ESPNTests
Feature: makeLogin

  Background:
    Given user has a valid logIn info
    And user enters to espn page

  @tc-002  @makeLogin
  Scenario: make login successfully
    When user clicks user icon
    When user clicks log In button
    When user fills logIn form
    Then logIn is done successfully
