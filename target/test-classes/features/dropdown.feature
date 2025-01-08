Feature: dropdown functionality

  @Dropdown @Tokyo
  Scenario: verify user can select a facility from the dropdown
    Given user is on appointment page
    When user select the facility "Tokyo CURA Healthcare Center" from the dropdown
    Then user verify the facility selected is "Tokyo CURA Healthcare Center"

  @Dropdown @Hongkong
  Scenario: verify user can select another facility from the dropdown
    Given user is on appointment page
    When user select the facility "Hongkong CURA Healthcare Center" from the dropdown
    Then user verify the facility selected is "Hongkong CURA Healthcare Center"

  @Dropdown @Seoul
  Scenario: verify user can select another facility from the dropdown
    Given user is on appointment page
    When user select the facility "Seoul CURA Healthcare Center" from the dropdown
    Then user verify the facility selected is "Seoul CURA Healthcare Center"