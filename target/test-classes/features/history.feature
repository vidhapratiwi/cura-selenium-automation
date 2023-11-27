Feature: verify history menu
  @History @HistoryNone
  Scenario: user look at history menu
    Given user has logged in
    When click hamburger menu
    Then click history
    Then no history shown

  @History @HistoryAppointment
  Scenario: user look at history after appointment
    Given user has logged in
    When user has made an appointment
    Then click hamburger menu
    Then click history
    Then history shown

