Feature: [SUC:06-11]-Create Manual Fines
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:06-11 @UAT_M8-11-01 @UAT_M8-11-02 @UAT_M8-11-03
  Scenario: UAT_M8-11-02-Verify the process of manual fines
    And Click on compliance and enforcement > Manual fines
    Then find taxpayer to create fine for with tin "C0021873"
    Then Switch to default
    Then Submit manual fine
    Then Verify error message "Tax Type: Validation Error: Value is required."
    Then Verify error message "Return Type: Validation Error: Value is required."
    Then Verify error message "Fine Code: Validation Error: Value is required."
    Then Verify error message "Amount: Validation Error: Value is required."
    Then Verify error message "Date: Validation Error: Value is required."
    Then Verify error message "Period: Validation Error: Value is required."
    Then select taxtype "Personal Income Tax"
    Then select return type
    Then select fine code as "1622122120317"
    Then Enter manual fine amount "12000"
    Then Select manual fine date as today
    Then Select manual fine period
    Then Submit manual fine
    Then Verify success message "Manual Fine saved successfully"
    Then Extract manual fine arn number "Manual Fine saved successfully"
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


  @SUC:06-11 @UAT_M8-11-04
  Scenario: UAT_M8-11-04-Verify the process of not authorised
    And Click on compliance and enforcement > Manual fines
    Then find taxpayer to create fine for with tin "C0021873"
    Then Switch to default
    Then select taxtype "Personal Income Tax"
    Then select return type
    Then select fine code as "1622122120317"
    Then Enter manual fine amount "12000"
    Then Select manual fine date as today
    Then Select manual fine period
    Then Submit manual fine
    Then Verify success message "Manual Fine saved successfully"
    Then Extract manual fine arn number "Manual Fine saved successfully"
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

  @SUC:06-11 @UAT_M8-11-05
  Scenario: UAT_M8-11-05-Verify the Process of  Taxpayer not Found
    And Click on compliance and enforcement > Manual fines
    Then find taxpayer to create fine for with tin "C0021873gg"
    Then Verify no data is found in table

