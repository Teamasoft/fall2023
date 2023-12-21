# User Registration and Authentication:**
#- Users should be able to create accounts with their personal information.
#- User authentication (email/password) for secure access

Feature: User Registration and Authentication

  Scenario: User Registration
    Given the user is on the registration page
    When the user provides their personal information:
      | First Name | John             |
      | Last Name  | Doe              |
      | Email      | john@example.com |
      | Password   | password123      |
    And submits the registration form
    Then the user should see a confirmation message
    And receive a verification email

  Scenario: User Authentication
    Given the user is on the login page
    When the user enters their email and password
      | Email           | john@example.com |
      | Password        | password123      |
    And clicks the login button
    Then the user should be successfully logged in
    And should see their dashboard
