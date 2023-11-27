Feature: cura login menu
  @LoginMenu
  Scenario Outline: user login menu
    Given user go to url link
    When click the side bar menu
    Then click login
    Then login page shown
    Then input correct <username> as username
    And input correct <password> as password
    Then click the login button
    Then user verify <status> login

    Examples:
      | username | password           | status  |
      | John Doe | ThisIsNotAPassword | success |
      | xxxx     | ThisIsNotAPassword | failed  |
      | John Doe | xxxx               | failed  |
      |          |                    | failed  |
