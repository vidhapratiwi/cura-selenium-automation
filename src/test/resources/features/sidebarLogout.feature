Feature: sidebar - logout
  @Sidebar @Logout
  Scenario:
    Given user already opened the side bar menu
    When user click logout
    Then user is logged out