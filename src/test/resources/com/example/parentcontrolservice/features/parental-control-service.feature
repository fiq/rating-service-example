Feature: Indicate whether a movie should be viewable based on parental control levels

  As a customer I don’t want my account to be able to access movies that
  have a higher parental control level than my current preference setting.

  Scenario Outline: Customer with parental control preferences(<PREFERENCE>) cannot watch movies with a higher parental control(<PARENTAL_CONTROL_LEVEL>)
    Given mother has a parental control preference setting of <PREFERENCE>
    And Jaws has a parental control level of <PARENTAL_CONTROL_LEVEL>
    When mother attempts to watch Jaws
    Then she will not be permitted to watch it
    Examples:
      | PREFERENCE | PARENTAL_CONTROL_LEVEL |
      | U          | PG                     |
      | U          | 18                     |
      | PG         | 12                     |
      | PG         | 18                     |
      | 12         | 15                     |
      | 12         | 18                     |
      | 15         | 18                     |

  Scenario Outline: Customer with a preference of <PREFERENCE> can watch movies with an encompassed parental control of (<PARENTAL_CONTROL_LEVEL>)
    Given mother has a parental control preference setting of <PREFERENCE>
    And Exorcist has a parental control level of <PARENTAL_CONTROL_LEVEL>
    When mother attempts to watch Exorcist
    Then she will be permitted to watch it
    Examples:
      | PREFERENCE | PARENTAL_CONTROL_LEVEL |
      | 18         | 15                     |
      | 15         | 12                     |
      | 12         | PG                     |
      | PG         | U                      |
      | U          | U                      |
      | 18         | 18                     |

  Scenario: A customer requesting a non-existant movie should receive an appropriate error
    Given mother has a parental control preference setting of U
    And the movie Ferris2 does not exist
    When mother attempts to watch Ferris2
    Then she will not be permitted to watch it
