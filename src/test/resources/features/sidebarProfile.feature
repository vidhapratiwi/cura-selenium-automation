Feature: sidebar - profile
  @Sidebar @Profile
  Scenario:
    Given user has already opened sidebar menu
    When user click profile
    Then user is directed to profile page