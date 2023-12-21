# User Roles:**
#- Admin role: Manage products, categories, and user accounts.
#- Customer role: Browse products, make purchases, and view orders.
#- Installer role: View installation requests and schedule appointments.

Feature: User Roles Functionality

  Scenario: Admin Manages Products, Categories, and User Accounts
    Given an admin user
    When managing products, categories, and user accounts
    Then they should be able to manage products, categories, and user accounts

  Scenario: Customer Interacts with Products and Installation Services
    Given a customer user
    When browsing products, viewing product details, and making purchases
    Then they should be able to browse products, view product details, and make purchases

  Scenario: Customer Requests Installation Services
    Given a customer user has purchased products
    When they request installation services for the purchased products
    Then they should be able to submit installation requests successfully

  Scenario: Customer Views Order History and Installation Requests
    Given a customer user
    When viewing order history and installation requests
    Then they should be able to view their order history and installation requests

  Scenario: Installer Views Installation Requests and Schedules Appointments
    Given an installer user
    When viewing installation requests and scheduling appointments
    Then they should be able to view installation requests and schedule appointments
