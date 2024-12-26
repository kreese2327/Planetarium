@US4 @SR2
Feature: Add planets and moons to planetarium
  As a user I want to add new planets and moons to the Planetarium so I can update my findings

  Background:
    Given the user is logged in on the home page

  @Negative @PR1 @PR2 @PR3
  Scenario Outline: The user can not add a planet with an invalid name
    When  the user adds a planet
    And   the user enters an invalid planet name "<planet name>"
    And   the user clicks submit
    Then  the user should get a browser alert saying "Invalid planet name"

    Examples:
      |planet name                    |
      |                               |
      |AbcdefghijklmnopqrstuvwxyzAbcde|
      |Planet!?)                      |
      |Earth                          |

  @Negative @MR1 @MR2 @MR3
  Scenario Outline: The user can not add a moon with an invalid name
    When  the user adds a moon
    And   the user enters an invalid moon name "<moon name>"
    And   the user enters a valid owner id
    And   the user clicks submit
    Then  the user should get a browser alert saying "Invalid moon name"

    Examples:
      |moon name                      |
      |                               |
      |AbcdefghijklmnopqrstuvwxyzAbcde|
      |Moon!?)                        |
      |Luna                           |

  @Negative @MR1 @MR2 @MR3
  Scenario: The user can not add a moon with an invalid owner
    When  the user adds a moon
    And   the user enters a valid moon name
    And   the user enters an invalid owner id
    And   the user clicks submit
    Then  the user should get a browser alert saying "Invalid planet id"

  @Negative @PR5
  Scenario: The user can not add a planet with an invalid file type
    When  the user adds a planet
    And   the user enters a valid planet name
    And   the user selects an invalid planet image
    And   the user clicks submit
    Then  the user should get a browser alert saying "Invalid file type"

  @Negative @MR6
  Scenario: The user can not add a moon with an invalid file type
    When  the user adds a moon
    And   the user enters a valid moon name
    And   the user selects an invalid moon image
    And   the user clicks submit
    Then  the user should get a browser alert saying "Invalid file type"

  @Positive @PR5
  Scenario Outline: the user can add a planet with valid data
    When  the user adds a planet
    And   the user enters a valid planet name
    And   the user selects a valid planet image "<file type>"
    And   the user clicks submit
    Then  the planet should be added

    Examples:
      |file type|
      |C:\Users\reese\Revature\Planetarium\src\test\resources\Celestial-Images\moon-1.jpg|
      |C:\Users\reese\Revature\Planetarium\src\test\resources\Celestial-Images\moon-5.png|

  @Positive @MR6
  Scenario Outline: the user can add a moon with valid data
    When  the user adds a moon
    And   the user enters a valid moon name
    And   the user enters a valid owner id
    And   the user selects a valid moon image "<file type>"
    And   the user clicks submit
    Then  the moon should be added

    Examples:
      |file type|
      |C:\Users\reese\Revature\Planetarium\src\test\resources\Celestial-Images\moon-1.jpg|
      |C:\Users\reese\Revature\Planetarium\src\test\resources\Celestial-Images\moon-5.png|

