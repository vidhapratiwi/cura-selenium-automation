Feature: sidebar menu - history
  @Sidebar @Menu @History
  Scenario:
    Given user already opened sidebar menu
    When user click history
    Then user is directed to history page