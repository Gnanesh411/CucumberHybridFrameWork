	Feature: Registration Functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register page
    When User enters below details into the fields
      | firstname    | Gnanesh              |
      | lastname     | Damodara             |
      | Telephone    |           1234567890 |
      | Password     |                12345 |
    And Selects Privacy Policy field
    And Clicks on Continue button
    Then Account should get successfully created

  Scenario: User creates an account with all fields
    Given User navigates to Register page
    When User enters below details into the fields
      | firstname    | Gnanesh              |
      | lastname     | Damodara             |
      | Telephone    |           1234567890 |
      | Password     |                12345 |
    And Selects Yes for newsletter
    And Selects Privacy Policy field
    And Clicks on Continue button
    Then Account should get successfully created

  Scenario: User creates a duplicate account
    Given User navigates to Register page
    When User enters below details into the fields with duplicate email
      | firstname    | Gnanesh              |
      | lastname     | Damodara             |
      | emailaddress | gnanesh123@gmail.com |
      | Telephone    |           1234567890 |
      | Password     |                12345 |
    And Selects Yes for newsletter
    And Selects Privacy Policy field
    And Clicks on Continue button
    Then User should get a proper warning about duplicate email

  Scenario: User creates an account without filling anyt details
    Given User navigates to Register page
    When User dont enter details into any fields
    And Clicks on Continue button
    Then User should get a proper warning messages for every mandatory field
