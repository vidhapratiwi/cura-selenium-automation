Feature: sidebar menu
  @Sidebar @Menu
  Scenario:
    Given user already on homepage
    When user click sidebar menu
    Then sidebar menu is diplayed