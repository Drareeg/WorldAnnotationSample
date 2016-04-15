Feature:test

  Scenario Outline: testing
    Given We have a monkey
    When We give him <give> bananas
    Then He has <has> bananas
    Examples:
      | give | has |
      | 2    | 2   |
      | 3    | 3   |
      | 5    | 5   |

