Feature:  appointment creation

  @Appointment @Positive
  Scenario: user make successful appointment all fields are filled
    Given user already on the appointment page
    When user select the facility "Tokyo CURA Healthcare Center" from dropdown
    Then user select checkbox
    And user select "Medicare" healthcare program
    And user select visit date "30/03/2025"
    And user verify selected date "30/03/2025"
    And user fill the comment textbox with "thank you"
    And the comment textbox should display "thank you"
    And user click the book appointment button
    Then user is directed to confirmation page
    And  appointment is succeed

  @Appointment @Positive @RequiredField
  Scenario: user make successful appointment required only
    Given user already on the appointment page
    When user select visit date "30/03/2025"
    And user verify selected date "30/03/2025"
    And user click the book appointment button
    Then user is directed to confirmation page
    And  appointment is succeed

  @Appointment @Negative @EmptyFields
  Scenario: user make failed appointment by not filling field
    Given user already on the appointment page
    And user click the book appointment button
    Then warning message to fill the required field displayed

  @Appointment @Negative @PastDate
  Scenario: user make failed appointment by filling a past date
    Given user already on the appointment page
    When user select visit date "30/03/2024"
    And user verify selected date "30/03/2024"
    And user click the book appointment button
    Then warning message to fill the required field displayed

  @Appointment @Homepage
  Scenario: verify "go to homepage" button working properly
    Given user has already made appointment and is on confirmation page
    When user click go to homepage button
    Then user is navigated to home page

