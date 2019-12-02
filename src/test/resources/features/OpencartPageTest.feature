Feature:Order products on OpenCart

  Scenario:
    Given User is on the OpenCart page
    When Login on OpenCart
    And Add product to cart
    Then Check product is in cart