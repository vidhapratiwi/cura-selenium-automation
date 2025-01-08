Feature: date picker functionality

  @DatePicker @Form
  Scenario: verify date picker visit date
    Given user on appointment page
    When user select the date "28/01/2025" from the calendar
    Then user verify the selected date is "28/01/2025"