Feature: Radio Button Functionality
@RadioButton

  Scenario: verify radio button functionality
    Given user is on the appointment page
    When user selects "Medicare" radio button
    Then user verifies "Medicare" radio button is selected
    And user verifies "Medicaid" radio button is not selected
    And user verifies "None" radio button is not selected
    When user selects "Medicaid" radio button
    Then user verifies "Medicaid" radio button is selected
    And user verifies "Medicare" radio button is not selected
    And user verifies "None" radio button is not selected
    When user selects "None" radio button
    Then user verifies "None" radio button is selected
    And user verifies "Medicare" radio button is not selected
    And user verifies "Medicaid" radio button is not selected
