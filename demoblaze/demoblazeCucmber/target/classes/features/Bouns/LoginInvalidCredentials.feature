Feature: LoginInvalidCredentials

  Scenario Outline: login InValidCredentials
    Given user open homepage and click on login link
    When user enter "<username>" and  "<password>" and press Signup
    Then error appear in alert msg appear
    Examples:
      | username         | password     |
      | FatmaAhmedMohamed| Password     |
      | fatma44842       | fatma        |
      | jjk              | jhkj!        |