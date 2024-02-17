Feature: Add to cart

  @smoke
   Scenario Outline: Add multiple quantity to the cart
    Given I am on the Store page
    When I add a "<product_name>" to the cart
    Then I see 1 "<product_name>" in the cart
    Examples:
      | product_name    |
      | Blue Shoes      |
      | Anchor Bracelet |