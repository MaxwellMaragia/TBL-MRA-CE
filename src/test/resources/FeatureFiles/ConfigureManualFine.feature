Feature: [SUC:06-08]-Configure Manual Fines
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:06-08 @UAT_M8-08-01 @UAT_M8-08-02 @UAT_M8-08-03
  Scenario: UAT_M8-08-02-Verify the process of configuration of manual fines rules-Verify the process of edit manual fines rules
    And Click on compliance and enforcement > Configure fine rules
    Then Click on Create new button
    Then Enter fine code as current timestamp
    Then Enter fine rule description as "Processing configuration test"
    Then Select taxtype to configure fine rule for as "Personal Income Tax"
    Then Enter legal reference as "timestamp"
    Then Enter minimum fine amount as "10000"
    Then Enter maximum fine amount as "120000"
    Then Select fine unit type "Currency Points"
    Then Click save for fine
    Then Verify success message "Fine Rule Configuration saved successfully"
    And Click on compliance and enforcement > Configure fine rules
    Then Search for fine code
    Then Change fine minimum amount to "11000"
    Then Click save for fine
    Then Verify success message "Fine Rule Configuration saved successfully"
    And Click on compliance and enforcement > Configure fine rules
    And Search for fine code using invalid data
    Then Verify no data is found in table
    Then Search for fine code to view
    Then Click view to view fine code
    Then Verify fine code and readonly
    And Click on compliance and enforcement > Configure fine rules
    Then Click on Create new button
    Then Enter fine code as previous
    Then Enter fine rule description as "Processing configuration test"
    Then Select taxtype to configure fine rule for as "Personal Income Tax"
    Then Enter legal reference as ""
    Then Enter minimum fine amount as "10000"
    Then Enter maximum fine amount as "120000"
    Then Select fine unit type "Currency Points"
    Then Click save for fine
    Then Verify error message "Fine code already exist"
    Then Enter new fine code as current timestamp
    Then Click save for fine
    Then Verify success message "Fine Rule Configuration saved successfully"

