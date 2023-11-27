Feature: verify profile menu
  @Profile
  Scenario: user look at profile menu
    Given user done login
    When click side menu
    Then click profile
    Then profile shown