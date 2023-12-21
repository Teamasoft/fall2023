# Notifications:**
#- Send order confirmations and updates to customers via email or push notifications.
#- Inform installers about new installation requests.

Feature: Notifications

  Scenario: Send Order Confirmations via Email
    Given a customer places an order
    When the order is confirmed
    Then the system should send an order confirmation email to the customer

  Scenario: Send Order Updates via Push Notifications
    Given a customer's order status changes
    When an update is available
    Then the system should send a push notification to the customer

  Scenario: Inform Installers about New Installation Requests
    Given a new installation request is submitted
    When the request is received
    Then the system should notify the available installers about the new request

  Scenario: Send Email Confirmation to Installer
    Given an installer is assigned to an installation request
    When the assignment is confirmed
    Then the system should send an email confirmation to the installer
