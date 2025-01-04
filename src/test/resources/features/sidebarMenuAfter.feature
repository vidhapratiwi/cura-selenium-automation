Feature: sidebar menu after login
  @Sidebar @Menu @After
  Scenario:
    Given user already login and on homepage
    When user click on sidebar menu
    Then sidebar menu displayed