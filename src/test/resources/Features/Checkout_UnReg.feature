Feature: UnRegistered Checkout
  Scenario:
    Given user loads website
    When user searches for an item
    And user checkout with that item
    And user proceeds to checkout as guest
    And user enters shipping address
    And user enters payment information
    And user places order
    Then Order should have been placed successfully
    Then User closes browser