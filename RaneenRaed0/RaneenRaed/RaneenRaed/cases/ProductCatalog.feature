# Product Catalog:**
#- Categories: Products should be organized into categories (e.g., Interior, Exterior,Electronics).
#- Product listings: Detailed product descriptions, images, prices, and availability.
#- Search and filter options to easily find products.

Feature: Product Catalog

  Scenario: View Product Categories
    Given the user is on the product catalog page
    When the user navigates to the categories section
    Then the user should see a list of available product categories
    And can click on a category to view products within that category

  Scenario: View Product Listings
    Given the user is on the product catalog page
    When the user selects a product category
    Then the user should see a list of product listings within that category
    And each product listing should display:
      | Product Name | Product Description                          | Price   | Availability |
      | Car Mats     | High-quality rubber car floor mats.          | $29.99  | In Stock     |
      | Car Wax      | Premium car wax for a brilliant shine.       | $19.99  | In Stock     |
      | GPS Navigator| Advanced GPS navigation system for vehicles. | $149.99 | Out of Stock |

  Scenario: Search for Products
    Given the user is on the product catalog page
    When the user enters a search term in the search bar
      | Search Term  | Car Mats   |
    And clicks the search button
    Then the user should see a list of product listings matching the search term
    And the product listings should include "Car Mats"

  Scenario: Filter Products
    Given the user is on the product catalog page
    When the user applies filters:
      | Category       | Electronics |
      | Price Range    | $50 - $200  |
      | Availability   | In Stock    |
    And clicks the apply filters button
    Then the user should see a filtered list of product listings
    And all displayed products should belong to the "Electronics" category
    And their prices should fall within the specified range
    And all products should be marked as "In Stock"
