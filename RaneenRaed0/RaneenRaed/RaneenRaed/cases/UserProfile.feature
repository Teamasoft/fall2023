#User Profile:**
#- Customers can edit their profiles (e.g., change contact information).
#- View order history and installation requests.

Feature: User Profile Functionality
  Functionality related to user profiles

  Scenario: Customers can edit their profiles
    Given a customer wants to edit their profile
    When they update their contact information
    Then they should be able to successfully edit their profile

  Scenario: Viewing order history and installation requests
    Given a customer wants to view their order history and installation requests
    When they navigate to the corresponding sections in their profile
    Then they should be able to see their order history and installation requests
