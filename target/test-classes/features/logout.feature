Feature: user logout
  @Logout
  Scenario:user logout from cura
    Given user login on the website
    When click side bar menu
    Then click logout button
    Then back to url