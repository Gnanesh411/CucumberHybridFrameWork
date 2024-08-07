Feature: Login Functionality

  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address "gnanesh123@gmail.com" into email field
    And User has entered valid password "12345" into password field
    And User clicks on Login button
    Then User should get successfully logged in

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User has entered invalid password "124445" into password field
    And User clicks on Login button
    Then User should get a warning message about credentials mismatch

  Scenario: Login with valid email address and Invalid password
    Given User navigates to login page
    When User enters valid email address "gnanesh123@gmail.com" into email field
    And User has entered invalid password "124445" into password field
    And User clicks on Login button
    Then User should get a warning message about credentials mismatch

  Scenario: Login with Invalid email address and valid password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User has entered valid password "12345" into password field
    And User clicks on Login button
    Then User should get a warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User dont enter email address into email field
    And User dont enter password into password field
    And User clicks on Login button
    Then User should get a warning message about credentials mismatch
