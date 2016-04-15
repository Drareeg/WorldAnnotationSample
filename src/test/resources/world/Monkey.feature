Feature:test

  Scenario Outline: good monkey
    Given We are in the world
    When We give a monkey <give> bananas
    Then He has <has> bananas
    Examples:
      | give | has |
      | 2    | 2   |
      | 3    | 3   |
      | 5    | 5   |

    Scenario: other monkeys don't get shit
      Given We are in the world
      When We give a monkey 5 bananas
      And We give monkey Jakob 2 bananas
      And We give monkey Jos 1 bananas
      Then Jakob has 2 bananas
      And Jos has 1 bananas
      And He has 5 bananas

