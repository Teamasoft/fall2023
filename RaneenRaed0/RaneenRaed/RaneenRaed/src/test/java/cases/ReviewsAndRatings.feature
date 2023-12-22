# Reviews and Ratings:*
#- Allow customers to leave reviews and ratings for products and installation services.
#- Display average ratings and reviews on product pages.

Feature: Reviews and Ratings

  Scenario: Customers leave reviews and ratings for products
    Given a customer is logged in
    When the customer selects a product
    And leaves a review and rating
    Then the system should record the review and rating for the product

  Scenario: Customers leave reviews and ratings for installation services
    Given a customer is logged in
    When the customer selects an installation service
    And leaves a review and rating
    Then the system should record the review and rating for the installation service

  Scenario: Display average ratings and reviews on product pages
    Given there are multiple reviews and ratings for a product
    When a customer views the product page
    Then the system should display the average rating and reviews for that product

  Scenario: Display average ratings and reviews on installation service pages
    Given there are multiple reviews and ratings for an installation service
    When a customer views the installation service page
    Then the system should display the average rating and reviews for that installation service

  Scenario: Customers view their own reviews and ratings
    Given a customer is logged in
    When the customer navigates to their profile
    And selects the "My Reviews" section
    Then the system should display a list of reviews and ratings submitted by that customer
