Feature: make appointment button
  @MakeAppointmentButton

  Scenario: verify make appointment button
    Given user already login and is in homepage
    When user click make appointment button
    Then appointment form page displayed