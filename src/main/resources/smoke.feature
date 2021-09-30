Feature: Smoke
  As a user
  I want to test all main site https://www.amazon.com/ functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check "Registration" page
    Given User opens '<homePage>' page
    And User goes to Create account page
    Then User checks your name field
    And User checks login field is displayed
    And User checks password field is displayed
    And User checks re-enter password field is displayed
    And User checks continue button is displayed
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check required field Name on "Registration" page
    Given User opens '<homePage>' page
    And User goes to Create account page
    And User fills in '<login>', '<password>' without name
    Then User clicks continue button without filling in name
    Examples:
      | homePage                | login  | password |
      | https://www.amazon.com/ | qwerty | qwerty   |

  Scenario Outline: Check required field Login on "Registration" page
    Given User opens '<homePage>' page
    And User goes to Create account page
    And User fills in '<name>', '<password>' without login
    Then User clicks continue button without filling in login
    Examples:
      | homePage                | name  | password |
      | https://www.amazon.com/ | qwerty | qwerty   |

  Scenario Outline: Check changing the language
    Given User opens '<homePage>' page
    And User clicks on language button
    When User chooses spanish language
    And User saves changes
    Then User checks the home page language
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check quantity of nav links
    Given User opens '<homePage>' page
    Then User checks the quantity of nav links
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check quantity of nav footer links
    Given User opens '<homePage>' page
    Then User checks the quantity of nav footer links
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check social media buttons
    Given User opens '<homePage>' page
    And User clicks About Amazon button
    Then User checks Facebook button
    And User checks Instagram button
    And User checks Linkedin button
    And User checks Twitter button
    And User checks Youtube button
    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check "Search" function
    Given User opens '<homePage>' page
    And User checks search field is displayed
    And User checks cart button is displayed
    And User checks language choice button is displayed
    When User makes search by keyword '<keyword>'
    And User clicks the first item containing keyword
    Then User checks that title of item at product page contains '<keyword>'
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | ZenBook |

  Scenario Outline: Check "Add to cart" function
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks the first item containing keyword
    And User clicks the Add To Cart button
    Then User checks that item added to cart
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | ZenBook |

  Scenario Outline: Check unlogged user can't buy item
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks the first item containing keyword
    And User clicks buy button
    Then User checks that unlogged user is redirected to sign-in page
    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | ZenBook |