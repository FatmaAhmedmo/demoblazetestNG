Feature: SignUpNewUsers_DataFaker Feature
  Scenario: SignUp new user with DataFaker credentials
    Given user open homepage and click on SignUp link
    When user enter Datafaker "username" and Datafaker "password" and press Signup
    Then alert msg appear
