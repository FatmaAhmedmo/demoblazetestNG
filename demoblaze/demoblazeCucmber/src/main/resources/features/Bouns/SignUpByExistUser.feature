Feature: SignUpByExistUser Feature
  Scenario: SignUp new user with exist credentials
    Given user open homepage and click on SignUp link
    When user enter exist "username" and exist "password" and press Signup
    Then user already exist alert msg appear