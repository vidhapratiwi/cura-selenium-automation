Feature: sidebar menu - before login
  @Sidebar @Menu @Before
  Scenario:
    Given user already on homepage
    When user click sidebar menu
    Then sidebar menu is diplayed