Feature: checkbox functionality
  @Checkbox
  Scenario: verify hospital readmission checkbox functionality
    Given user already on appointment page
    When user click the checkbox
    Then user verify it is checked
    And user click the checkbox
    Then user verify it is unchecked