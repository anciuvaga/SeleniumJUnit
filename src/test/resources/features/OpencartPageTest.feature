Feature:Order products on OpenCart

  Scenario: Product added to Cart is displayed in the shopping cart
    Given User is on the OpenCart page
    When Login on OpenCart
      | bob.bob@gmail.com | bobbob |
    And Add product to cart
    And Go to ShoppingCart
    Then Product added is displayed in the cart

  Scenario: Shopping cart is empty when user removes a product from shopping cart
    Given User is on the OpenCart page
    When Login on OpenCart
      | john.goldman@gmail.com | johngoldman |
    And Add product to cart
    And Go to ShoppingCart
    Then Product added is displayed in the cart
    When Remove the product from cart
    Then Shoppingcart is empty

  Scenario: Check that item is removed when adding multiple items
    Given User is on the OpenCart page
    When Login on OpenCart
      | john.white@gmail.com | johnwhite |
    And Add product to cart
    And Add another product
    Then Items added are displayed in the cart
    When Remove the product from cart
    Then Validate that removed item is missing from shopping cart