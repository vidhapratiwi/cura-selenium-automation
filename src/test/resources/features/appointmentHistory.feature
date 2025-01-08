Feature: appointment history

  @Validation @History
  Scenario: verify appointment is recorded in history page
    Given user has already made appointment and on confirmation page
    When user navigate to history page
    Then verify the appointment should be displayed

  @Validation @History @Logout
  Scenario: verify appointment history is not lost after logout and login back
    Given user has already made appointment and on confirmation page
    When user navigate to history page
    Then verify the appointment should be displayed
    And user log out and log in
    And user navigate again to history page
    Then verify the appointment should be displayed
