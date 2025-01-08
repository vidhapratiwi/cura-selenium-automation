Feature: user login verification
  @Login
  Scenario Outline: user login home
    Given user go to url
    When click make appointment button
    Then login page appeared
    Then input valid <username> as username
    And input valid <password> as password
    Then click login button
    Then user verify <status> login result

    Examples:
      | username | password           | status  |
      | John Doe | ThisIsNotAPassword | success |
      | xxxx     | ThisIsNotAPassword | failed  |
      | John Doe | xxxx               | failed  |
      |          | ThisIsNotAPassword | failed  |
      | John Doe |                    | failed  |
      |          |                    | failed  |
      | john doe | ThisIsNotAPassword | success |
      | JOHN DOE | ThisIsNotAPassword | success |
      | John Doe | thisisnotapassword | failed  |
      | John Doe | THISISNOTAPASSWORD | failed  |