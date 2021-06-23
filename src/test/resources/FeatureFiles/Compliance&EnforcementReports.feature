Feature: [SUC:06-07]-Generate Compliance and Enforcement Reports

  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login
    Then Click reporting > reports

  @SUC:06-07 @UAT_M8-08-07-02
  Scenario: UAT_M8-08-07-02-Verify the Process of Print Reports- Compliance Performance statistics
    Then Select report to print "Compliance Performance Statistics"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify error message "Tax Office: Validation Error: Value is required."
    Then Verify error message "Tax Type: Validation Error: Value is required."
    Then Select report file type "PDF"
    Then Enter start date as "30/01/2021"
    Then Select ending date as today
    Then Select tax office "All"
    Then Select return type
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Compliance Performance Statistics.pdf" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Compliance Performance Statistics.xls" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"

  @SUC:06-07 @UAT_M8-08-07-04
  Scenario: UAT_M8-08-07-04-Verify the Process of Print Reports- Performance Statistics Report
    Then Select report to print "Performance Statistics Report"
    Then Select report file type "PDF"
    Then Enter start date as "30/01/2021"
    Then Select ending date as today
    Then Select tax office "All"
    Then Select return type
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Performance Statistics Report.pdf" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Performance Statistics Report.xls" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"

  @SUC:06-07 @UAT_M8-08-07-05
  Scenario: UAT_M8-08-07-05-Verify the Process of Print Reports- Report Short/Non Paying Statistics
    Then Select report to print "NonPayerShortPayReport"
    Then Select report file type "PDF"
    Then Enter start date as "30/01/2021"
    Then Select ending date as today
    Then Select tax office "All"
    Then Select return type
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "NonPayerShortPayReport.pdf" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "NonPayerShortPayReport.xls" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"

  @SUC:06-07 @UAT_M8-08-07-08
  Scenario: UAT_M8-08-07-08-Verify the Process of Print Reports- Non-filers Report
    Then Select report to print "Non Filers Report"
    Then Select report file type "PDF"
    Then Enter start date as "30/01/2021"
    Then Select ending date as today
    Then Select tax office "All"
    Then Select return type
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Non Filers Report.pdf" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"
    Then Select report file type "EXCEL"
    Then Click run report "frmReportDetails:RunReport"
    Then Verify file "Non Filers Report.xls" has been downloaded in downloads directory "C:\\Users\\maxma\\Downloads"

  @SUC:06-07 @UAT_M8-08-07-07
  Scenario: UAT_M8-08-07-07-Verify the process of abandon report
    Then Select report to print "Non Filers Report"
    Then Select report file type "PDF"
    Then Select ending date as today
    Then Click cancel to abandon report
    Then user is navigated back to "https://backoffice.mra.mw:8443/trips-ui/faces/reports/ReportTree.xhtml"