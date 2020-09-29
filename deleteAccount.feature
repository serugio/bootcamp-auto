@ESPNTests
Feature: deleteAccount

  Background:
    Given user enters to espn page
    And user is logged with a valid userName

  @tc-003  @deleteAccount
  Scenario: delete account successfully
    When user clicks user icon
    When user clicks espn profile button
    When user clicks delete account link
    Then user clicks confirm delete button
    Then account it's successfully deleted
