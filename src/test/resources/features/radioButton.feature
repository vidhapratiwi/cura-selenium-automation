Feature: Radio Button Functionality
@RadioButton

  Scenario: verify radio button functionality
    Given user is on the appointment page
    When user selects "Medicare" radio button
    Then user verify "Medicare" radio button is selected
    And user verify "Medicaid" radio button is not selected
    And user verify "None" radio button is not selected
    When user selects "Medicaid" radio button
    Then user verify "Medicaid" radio button is selected
    And user verify "Medicare" radio button is not selected
    And user verify "None" radio button is not selected
    When user selects "None" radio button
    Then user verify "None" radio button is selected
    And user verify "Medicare" radio button is not selected
    And user verify "Medicaid" radio button is not selected
