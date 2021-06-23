Feature: [SUC:06-04]-Configure Manual Penalty Rules
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:06-02 @UAT_M8-04-01 @UAT_M8-04-02 @UAT_M8-04-03
  Scenario: UAT_M8-04-02-Verify the process of configuration of manual penalty rules-Verify the process of edit manual penalty rules
    And Click on compliance and enforcement > Configure penalty rules
    Then Click on Create new button
    Then Enter penalty code as current timestamp
    Then Enter description as "Processing configuration test"
    Then Select taxtype to configure compliance for as "Personal Income Tax"
    Then Enter minimum amount as "10000"
    Then Enter maximum amount as "120000"
    Then Select fine unit type "Currency Points"
    Then Click save
    Then Verify success message "Penalty Rule Configuration saved successfully"
    And Click on compliance and enforcement > Configure penalty rules
    Then Search for penalty code
    Then Change minimum amount to "11000"
    Then Click save
    Then Verify success message "Penalty Rule Configuration saved successfully"
    And Click on compliance and enforcement > Configure penalty rules
    And Search for penalty code using invalid data
    Then Verify no data is found in table
    Then Search for penalty code to view
    Then Click view to view penalty code
    Then Verify code and readonly
    And Click on compliance and enforcement > Configure penalty rules
    Then Click on Create new button
    Then Enter penalty code as previous
    Then Enter description as "Processing configuration test"
    Then Select taxtype to configure compliance for as "Personal Income Tax"
    Then Enter minimum amount as "10000"
    Then Enter maximum amount as "120000"
    Then Select penalty type "Currency Points"
    Then Click save
    Then Verify error message "Penalty code already exist"
    Then Enter new penalty code as current timestamp
    Then Click save
    Then Verify success message "Penalty Rule Configuration saved successfully"

