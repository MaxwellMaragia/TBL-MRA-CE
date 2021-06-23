Feature: [SUC:06-05]-Create Manual Penalties
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:06-05 @UAT_M7-05-01 @UAT_M7-05-02 @UAT_M7-05-03
  Scenario: UAT_M7-05-02-Verify the process of manual penalties
    And Click on compliance and enforcement > Manual penalties
    Then find taxpayer to create penalty for with tin "C0021873"
    Then Switch to default
    Then Submit manual penalty
    Then Verify error message "Return Type: Validation Error: Value is required."
    Then Verify error message "Manual Penalty Type: Validation Error: Value is required."
    Then Verify error message "Amount: Validation Error: Value is required."
    Then Verify error message "Date: Validation Error: Value is required."
    Then Verify error message "Penalty Code: Validation Error: Value is required."
    Then Verify error message "Period: Validation Error: Value is required."
    Then Select penalty type
    Then select taxtype for penalty "Personal Income Tax"
    Then select return type for penalty
    Then select penalty code as "1622118013605"
    Then Enter manual penalty amount "12000"
    Then Select manual penalty date as today
    Then Select manual penalty period
    Then Submit manual penalty
    Then Verify success message "Manual Penalty saved successfully"
    Then Extract manual penalty arn number "Manual Penalty saved successfully"
    Then Open CRM and close modal
    Then Click on enforcement application link
    Then switch to frame0
    Then search for reference number
    Then Click on reference number
    Then switch to frame1
    Then approve transaction
    Then Click save CRM
    Then switch to frame1
    Then Manual fine status should be "Approved"


  @SUC:06-05 @UAT_M7-05-04
  Scenario: UAT_M7-05-04-Verify the process of not authorised
    And Click on compliance and enforcement > Manual penalties
    Then find taxpayer to create penalty for with tin "C0021873"
    Then Switch to default
    Then Select penalty type
    Then select taxtype for penalty "Personal Income Tax"
    Then select return type for penalty
    Then select penalty code as "1622118013605"
    Then Enter manual penalty amount "12000"
    Then Select manual penalty date as today
    Then Select manual penalty period
    Then Submit manual penalty
    Then Verify success message "Manual Penalty saved successfully"
    Then Extract manual penalty arn number "Manual Penalty saved successfully"
    Then Open CRM and close modal
    Then Click on enforcement application link
    Then switch to frame0
    Then search for reference number
    Then Click on reference number
    Then switch to frame1
    Then reject transaction after text "Tax Office" loads
    Then switch to frame1
    Then Enter Outcome Notes "Invalid"
    Then Enter Outcome Reason
    Then Click save CRM
    Then switch to frame1
    Then Manual fine status should be "Rejected"

  @SUC:06-05 @UAT_M7-05-05
  Scenario: UAT_M8-11-05-Verify the Process of  Taxpayer not Found
    And Click on compliance and enforcement > Manual penalties
    Then find taxpayer to create penalty for with tin "C00218yuu73"
    Then Verify no data is found in table

