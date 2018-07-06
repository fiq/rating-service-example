Feature: Indicate whether a movie should be viewable based on parental control levels

  Scenario Outline: As a customer I don’t want my account to be able to access movies that
  have a higher parental control level than my current preference setting.

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
