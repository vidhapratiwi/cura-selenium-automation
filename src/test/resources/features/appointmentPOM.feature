Feature:  make an appointment with pom
  @AppointmentFull
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
