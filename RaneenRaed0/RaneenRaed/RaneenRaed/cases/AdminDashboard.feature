# Admin Dashboard:**
#- Manage product categories (add, edit, delete).
#- Add and update product listings.
#- View and manage customer accounts.
#- Schedule and manage installation appointments.

Feature: Admin Dashboard Management

  Scenario: Admin manages product categories
    Given the admin is logged in
    When the admin navigates to the product categories section
    Then the admin should be able to add a new product category
    And edit an existing product category
    And delete an existing product category

  Scenario: Admin adds a new product category
    Given the admin is logged in
    When the admin navigates to the product categories section
    Then the admin should be able to add a new product category

  Scenario: Admin edits an existing product category
    Given the admin is logged in
    When the admin navigates to the product categories section
    Then the admin should be able to edit an existing product category

  Scenario: Admin deletes an existing product category
    Given the admin is logged in
    When the admin navigates to the product categories section
    Then the admin should be able to delete an existing product category

  Scenario: Admin adds and updates product listings
    Given the admin is logged in
    When the admin navigates to the product listings section
    Then the admin should be able to add a new product listing
    And update an existing product listing

  Scenario: Admin adds a new product listing
    Given the admin is logged in
    When the admin navigates to the product listings section
    Then the admin should be able to add a new product listing

  Scenario: Admin updates an existing product listing
    Given the admin is logged in
    When the admin navigates to the product listings section
    Then the admin should be able to update an existing product listing

  Scenario: Admin views and manages customer accounts
    Given the admin is logged in
    When the admin navigates to the customer accounts section
    Then the admin should be able to view a list of customer accounts
    And manage customer account details

  Scenario: Admin views a list of customer accounts
    Given the admin is logged in
    When the admin navigates to the customer accounts section
    Then the admin should be able to view a list of customer accounts

  Scenario: Admin manages customer account details
    Given the admin is logged in
    When the admin navigates to the customer accounts section
    Then the admin should be able to manage customer account details

  Scenario: Admin schedules and manages installation appointments
    Given the admin is logged in
    When the admin navigates to the installation appointments section
    Then the admin should be able to view a list of installation appointments
    And schedule a new installation appointment
    And manage existing installation appointments

  Scenario: Admin views a list of installation appointments
    Given the admin is logged in
    When the admin navigates to the installation appointments section
    Then the admin should be able to view a list of installation appointments

  Scenario: Admin schedules a new installation appointment
    Given the admin is logged in
    When the admin navigates to the installation appointments section
    Then the admin should be able to schedule a new installation appointment

  Scenario: Admin manages existing installation appointments
    Given the admin is logged in
    When the admin navigates to the installation appointments section
    Then the admin should be able to manage existing installation appointments
