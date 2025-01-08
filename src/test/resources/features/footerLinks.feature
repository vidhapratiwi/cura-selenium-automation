Feature: footer links functionality

  @Footer
  Scenario Outline:
    Given user in homepage
    When user click <linkName> link in the footer
    Then user is redirected to the correct <expectedURL>

    Examples:
      | linkName  | expectedURL
      | facebook  | https://www.facebook.com/
      | twitter   | https://x.com/
      | dribbbble | https://www.dribbble.com/
      | email     | mailto:info@katalon.com
