# Installation Requests:**
#- Customers can request installation services for certain products.
#- Form to specify installation details (e.g., car make/model, preferred date).
#- Installer availability and appointment scheduling.

Feature: Installation Service

  Scenario: Customer requests installation for purchased accessories
    Given a customer has purchased accessories
    When they request installation services for those accessories
    Then the installation request should be created successfully

  Scenario: Specifying installation details using a form
    Given a customer is requesting installation services
    When they fill out the installation form with details like car make/model and preferred date
    Then they should be able to specify installation details using the form

  Scenario: Customer modifies installation request details
    Given a customer has an existing installation request
    When they modify the installation request details
    Then the changes should be updated successfully

  Scenario: Customer cancels an installation request
    Given a customer has an existing installation request
    When they cancel the installation request
    Then the request should be removed from the system successfully

  Scenario: Installer views pending installation requests
    Given an installer is available for installations
    When they check the pending installation requests
    Then they should be able to view the list of pending requests

  Scenario: Installer schedules an installation appointment
    Given an installer is available for installations
    When they schedule an appointment for an installation request
    Then the appointment should be confirmed and added to the calendar
