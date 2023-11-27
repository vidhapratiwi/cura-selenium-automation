Feature: make an appointment
  @Appointment @Full
  Scenario: user make an appointment
    Given user already login
    When user is on make appoinment page
    Then select facility
    And select apply or admission checkbox
    And select healthcare program option
    And select visit date
    And fill comment
    Then select book appointment button
    Then appointment confirmation shown

  @Appointment @Required
  Scenario: user make appointment required only
    Given user already login
    When user is on make appoinment page
    And select visit date
    Then select book appointment button
    Then appointment confirmation shown

  @Appointment @None
  Scenario: user make appointment none is selected
    Given user already login
    When user is on make appoinment page
    Then select book appointment button
    Then error message appear

  @Appointment @PastDate
  Scenario: user make appointment past date
    Given user already login
    When user is on make appoinment page
    And select past visit date
    Then select book appointment button
    Then error message appear

