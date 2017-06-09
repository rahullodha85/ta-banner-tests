Feature: Registered Checkout
  Scenario:
    Given user loads website
    When user searches for an item
    And user checkout with that item
    And user successfully logs in with credentials
    And user places order
    Then Order should have been placed successfully
    Then User closes browser