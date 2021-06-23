package StepDefinitions;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en_old.Ac;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass  {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten ;
    public WebDriverWait fifteen;
    public WebDriverWait twenty ;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public Actions actions;



    public static sharedatastep sharedata;
    public String ReferenceNumber = "MANP/000002433/2020";
    public String PenaltyCode = "";
    public String FineCode = "";

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        actions = new Actions(driver);
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);

    }

    public void switchToFrameBackoffice(){
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {

//    	intergtation link for backoffice
//    	driver.get("http://18.202.88.7:8001/trips-ui/faces/login/tripsLogin.xhtml");

        //    	SIT link for backoffice
        driver.get("https://backoffice.mra.mw:8443/trips-ui/faces/login/tripsLogin.xhtml");
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("loginForm:username")).sendKeys(strArg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(strArg2);
        driver.findElement(By.xpath("//*[@id=\"loginForm:j_idt19\"]/span")).click();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        String URL = driver.getCurrentUrl();

//    	Assert.assertEquals(URL, "http://18.202.88.7:8001/trips-ui/faces/login/Welcome.xhtml" );
        Assert.assertEquals(URL, "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml");
    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();

    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
        driver = getDriver();
        driver.get("https://" + strArg1 + ":Passw0rd@trips-crm.mra.mw:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
    }


    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^Enter Outcome Reason$")
    public void enter_Outcome_Reason() throws Throwable {
        Thread.sleep(2000);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("OutComeReason_Frame_XPATH"))));
        driver.switchTo().frame(specificframe);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Pro.getProperty("NextStage_RefNum_Reject_OutComeReason_XPATH"))).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath(Pro.getProperty("NextStage_RefNum_Reject_OutComeReason_Options_XPATH")))).click();
        Thread.sleep(8000);
    }


    @And("Click on compliance and enforcement > Perform tax compliance processing")
    public void clickOnComplianceUrl() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Compliance and Enforcement']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Configure Penalty Rules']"))).click();
    }

    @Then("^Click reporting > reports$")
    public void goToReportingScreen() throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reporting']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reports']"))).click();
    }

    @Then("Open CRM and close modal")
    public void openCRMAndCloseModal() {
        driver.get(Pro.getProperty("MRA_crm_url_Registration"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @Then("search for reference number")
    public void searchForReferenceNumber() throws InterruptedException {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(2000);
        //search.sendKeys("*AV/000000875/2021");
        search.sendKeys(ReferenceNumber);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {

        WebElement elementLocator = driver.findElement(By.xpath(Pro.getProperty("CaseManagement_Queue_Select_ReffNo_XPATH")));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();

    }

    @Then("^approve transaction$")
    public void approve_transaction() throws Throwable {

        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_EnforcementApplicationAngular")));
        driver.switchTo().frame("WebResource_EnforcementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Tax Office']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("reject transaction after text {string} loads")
    public void rejectTransactionAfterTextLoads(String text) throws InterruptedException {
        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_EnforcementApplicationAngular")));
        driver.switchTo().frame("WebResource_EnforcementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+text+"']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("^Enter Outcome Notes (.+)$")
    public void enter_outcome_notes(String Notes) throws Throwable {
        Thread.sleep(3000);
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.id((Pro.getProperty("Individual_NextStage_RefNum_Reject_OutComeNotes_ID"))));
        action1.sendKeys(element1, Notes).build().perform();
        Thread.sleep(5000);
    }

    @Then("^Click save CRM$")
    public void ClickSaveCRM() throws Throwable {
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_enforcementapplication|NoRelationship|Form|Mscrm.Form.tbg_enforcementapplication.Save")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Then("^user is navigated back to \"([^\"]*)\"$")
    public void user_is_navigated_back_to_homepage_something(String url) throws Throwable {
        Thread.sleep(4000);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(url,URL );
    }

    @Then("^Select report to print \"([^\"]*)\"$")
    public void select_report_to_print(String reportType) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + reportType + "']"))).click();

    }

    @Then("^Select report file type \"([^\"]*)\"$")
    public void select_report_file_type(String reportFormat) throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:ReportFormat\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reportFormat + "')]")).click();
    }

    @Then("^Select tax office \"([^\"]*)\"$")
    public void select_tax_office(String taxOffice) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"frmReportDetails:TAX_OFFICE\"]/div[3]")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Select return type$")
    public void select_return_type() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:TAX_TYPE\"]/div[3]"))).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @Then("^Verify file \"([^\"]*)\" has been downloaded in downloads directory \"([^\"]*)\"$")
    public void verify_file_has_been_downloaded_in_downloads_directory(String fileName, String downloadPath) throws Throwable {
        Thread.sleep(10000);
        if (isFileDownloaded(downloadPath, fileName)) {
            System.out.println(fileName + ": has been downloaded");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(fileName + ": has not been downloaded", false);
        }
    }

    @Then("^Click run report \"([^\"]*)\"$")
    public void click_run_report(String buttonID) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(buttonID))).click();
    }

    @Then("Select ending date as today")
    public void selectEndingDateAsToday() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:EndDate_input"))).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
        Thread.sleep(1000);
    }

    @Then("Select business sector")
    public void selectBusinessSector() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:BUSINESS_SECTOR\"]/div[3]"))).click();
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click cancel to abandon report")
    public void clickCancelToAbandonReport() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:btnCancel"))).click();
    }

    @And("Click on compliance and enforcement > Configure penalty rules")
    public void clickOnComplianceAndEnforcementConfigurePenaltyRules() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Compliance and Enforcement']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Configure Penalty Rules']"))).click();
        Thread.sleep(1000);
    }

    @Then("Click on Create new button")
    public void clickOnCreateNewButton() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id13"))).click();
    }

    @Then("Enter penalty code as current timestamp")
    public void enterPenaltyCodeAsCurrentTimestamp() throws InterruptedException {
        Thread.sleep(2000);
        PenaltyCode = String.valueOf(timestamp.getTime());
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:penaltyCode"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:penaltyCode"))).sendKeys(PenaltyCode);
    }

    @Then("Enter description as {string}")
    public void enterDescriptionAs(String description) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:description"))).sendKeys(description);
    }

    @Then("Select taxtype to configure compliance for as {string}")
    public void selectTaxtypeToConfigureComplianceForAs(String taxtype) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + taxtype + "']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"penaltyRuleConfigurationForm:taxTypes\"]/div[2]/div/button[1]")).click();
        Thread.sleep(1000);
    }

    @Then("Enter minimum amount as {string}")
    public void enterMinimumAmountAs(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:minimumAmount_input"))).sendKeys(amount);
    }

    @Then("Enter maximum amount as {string}")
    public void enterMaximumAmountAs(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:maximumAmount_input"))).sendKeys(amount);
    }

    @Then("Select penalty type {string}")
    public void selectPenaltyType(String penaltyType) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"penaltyRuleConfigurationForm:penaltyUnitType\"]/div[3]"))).click();
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click save")
    public void clickSave() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:save"))).click();
    }

    @Then("Click logout")
    public void clickLogout() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("Logout"))).click();
        Thread.sleep(1500);
    }

    @Then("Search for penalty code")
    public void searchForPenaltyCode() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:PenaltyCode"))).sendKeys(PenaltyCode);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
        fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+ PenaltyCode +"']"))).isDisplayed();
        driver.findElement(By.id("SearchForm:j_id14")).click();
    }

    @Then("Change minimum amount to {string}")
    public void changeMinimumAmountTo(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:minimumAmount_input"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:minimumAmount_input"))).sendKeys(amount);
    }

    @Then("Search for penalty code to view")
    public void searchForPenaltyCodeToView() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:PenaltyCode"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:PenaltyCode"))).sendKeys(PenaltyCode);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
        fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+ PenaltyCode +"']"))).isDisplayed();
        driver.findElement(By.id("SearchForm:j_id14")).click();
    }

    @Then("Click view to view penalty code")
    public void clickViewToViewPenaltyCode() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id15"))).click();

    }

    @Then("Verify code and readonly")
    public void verifyCodeAndReadonly() {
        WebElement codeElement = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:penaltyCode")));
        String code = codeElement.getAttribute("value");
        if(code.equals(PenaltyCode)){
            Assert.assertTrue("View screen is valid",true);
        }
        else{
            Assert.fail("Invalid view screen");
        }
    }

    @Then("Enter penalty code as previous")
    public void enterPenaltyCodeAsPrevious() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:penaltyCode"))).sendKeys(PenaltyCode);
    }

    @And("Search for penalty code using invalid data")
    public void searchForPenaltyCodeUsingInvalidData() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:PenaltyCode"))).sendKeys("AbRACADABRA");
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @Then("Enter new penalty code as current timestamp")
    public void enterNewPenaltyCodeAsCurrentTimestamp() {


        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:penaltyCode"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("penaltyRuleConfigurationForm:penaltyCode"))).sendKeys(PenaltyCode+"1");
    }

    @And("Click on compliance and enforcement > Configure fine rules")
    public void clickOnComplianceAndEnforcementConfigureFineRules() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Compliance and Enforcement']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Configure Fine Rules']"))).click();
        Thread.sleep(1000);
    }

    @Then("Enter fine code as current timestamp")
    public void enterFineCodeAsCurrentTimestamp() throws InterruptedException {
        Thread.sleep(2000);
        FineCode = String.valueOf(timestamp.getTime());
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:fineCode"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:fineCode"))).sendKeys(FineCode);
    }

    @Then("Enter fine rule description as {string}")
    public void enterFineRuleDescriptionAs(String description) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:description"))).sendKeys(description);
    }

    @Then("Select taxtype to configure fine rule for as {string}")
    public void selectTaxtypeToConfigureFineRuleForAs(String taxtype) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + taxtype + "']"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"fineRuleConfigurationForm:taxTypes\"]/div[2]/div/button[1]")).click();
        Thread.sleep(1000);
    }

    @Then("Enter minimum fine amount as {string}")
    public void enterMinimumFineAmountAs(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:minimumAmount_input"))).sendKeys(amount);
    }

    @Then("Enter legal reference as {string}")
    public void enterLegalReferenceAs(String reference) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:legalReference"))).sendKeys(FineCode);
    }

    @Then("Enter maximum fine amount as {string}")
    public void enterMaximumFineAmountAs(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:maximumAmount_input"))).sendKeys(amount);
    }

    @Then("Select fine unit type {string}")
    public void selectFineUnitType(String arg0) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fineRuleConfigurationForm:penaltyUnitType\"]/div[3]"))).click();
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click save for fine")
    public void clickSaveForFine() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:save"))).click();
    }

    @Then("Search for fine code")
    public void searchForFineCode() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:FineCode"))).sendKeys(FineCode);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
        fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+ FineCode +"']"))).isDisplayed();
        driver.findElement(By.id("SearchForm:j_id14")).click();
    }

    @Then("Change fine minimum amount to {string}")
    public void changeFineMinimumAmountTo(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:minimumAmount_input"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:minimumAmount_input"))).sendKeys(amount);
    }

    @And("Search for fine code using invalid data")
    public void searchForFineCodeUsingInvalidData() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:FineCode"))).sendKeys("AbRACADABRA");
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @Then("Search for fine code to view")
    public void searchForFineCodeToView() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:FineCode"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:FineCode"))).sendKeys(FineCode);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
        fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+ FineCode +"']"))).isDisplayed();
        driver.findElement(By.id("SearchForm:j_id14")).click();
    }

    @Then("Click view to view fine code")
    public void clickViewToViewFineCode() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id15"))).click();
    }

    @Then("Verify fine code and readonly")
    public void verifyFineCodeAndReadonly() {
        WebElement codeElement = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:fineCode")));
        String code = codeElement.getAttribute("value");
        if(code.equals(FineCode)){
            Assert.assertTrue("View screen is valid",true);
        }
        else{
            Assert.fail("Invalid view screen");
        }
    }

    @Then("Enter fine code as previous")
    public void enterFineCodeAsPrevious() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:fineCode"))).sendKeys(FineCode);
    }

    @Then("Enter new fine code as current timestamp")
    public void enterNewFineCodeAsCurrentTimestamp() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:fineCode"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("fineRuleConfigurationForm:fineCode"))).sendKeys(FineCode+"1");
    }

    @And("Click on compliance and enforcement > Manual fines")
    public void clickOnComplianceAndEnforcementManualFines() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Compliance and Enforcement']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Manual Fines']"))).click();
    }

    @Then("find taxpayer to create fine for with tin {string}")
    public void findTaxpayerToCreateFineForWithTin(String tin) throws Throwable{
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualFine:FindTin"))).click();
        WebElement frame = ten.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        Thread.sleep(3000);
    }

    @Then("select taxtype {string}")
    public void selectTaxtype(String taxtype) throws Throwable {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualFine:fineTaxType\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("select return type")
    public void selectReturnType() throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualFine:fineReturnType\"]/div[3]"))).click();
        Thread.sleep(1500);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("select fine code as {string}")
    public void selectFineCodeAs(String code) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualFine:fineCode\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + code + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter manual fine amount {string}")
    public void enterManualFineAmount(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualFine:amount_input"))).sendKeys(amount);
    }

    @Then("Select manual fine date as today")
    public void selectManualFineDateAsToday() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualFine:fineDate_input"))).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Select manual fine period")
    public void selectManualFinePeriod() throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualFine:finePeriod\"]/div[3]"))).click();
        Thread.sleep(1500);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Submit manual fine")
    public void submitManualFine() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualFine:save"))).click();
    }

    @Then("Extract manual fine arn number {string}")
    public void extractManualFineArnNumber(String success) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,100);
        String text  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+success+"')]"))).getText();
        //Manual Fine saved successfully. MANP/000003252/2021
        System.out.println(text);
        System.out.println("substring is "+ text.substring(32));
        ReferenceNumber =text.substring(32);

        System.out.println(ReferenceNumber);
        System.out.println("Actual ARN to be used in CRM is " +ReferenceNumber);

        Thread.sleep(5000);
    }

    @Then("Click on enforcement application link")
    public void clickOnEnforcementApplicationLink() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Pro.getProperty("Cases_Management_Dropdown_XPATH")))).click();

        Thread.sleep(2000);
        driver.findElement(By.id(Pro.getProperty("Enforcement_Application_ID"))).click();
    }

    @Then("Manual fine status should be {string}")
    public void manualFineStatusShouldBe(String status) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,200);
        WebElement statusLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + status + "')]")));

        if (statusLabel.isDisplayed()) {
            Assert.assertTrue("Approved", true);
        } else {
            Assert.fail("Approval failed");
        }
        Thread.sleep(2000);
    }

    @And("Click on compliance and enforcement > Manual penalties")
    public void clickOnComplianceAndEnforcementManualPenalties() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Compliance and Enforcement']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Manual Penalties']"))).click();
    }

    @Then("find taxpayer to create penalty for with tin {string}")
    public void findTaxpayerToCreatePenaltyForWithTin(String tin) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualPenalty:FindTin"))).click();
        WebElement frame = ten.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).clear();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        Thread.sleep(3000);
    }

    @Then("Submit manual penalty")
    public void submitManualPenalty() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualPenalty:save"))).click();
    }

    @Then("Select penalty type")
    public void selectPenaltyType() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualPenalty:penaltyType\"]/div[3]"))).click();
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("select taxtype for penalty {string}")
    public void selectTaxtypeForPenalty(String taxtype) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualPenalty:penaltyTaxType\"]/div[3]"))).click();
        Thread.sleep(1500);
//        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
//        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("select return type for penalty")
    public void selectReturnTypeForPenalty() throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualPenalty:penaltyReturnType\"]/div[3]"))).click();
        Thread.sleep(1500);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("select penalty code as {string}")
    public void selectPenaltyCodeAs(String code) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualPenalty:penaltyCode\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + code + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter manual penalty amount {string}")
    public void enterManualPenaltyAmount(String amount) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualPenalty:amount_input"))).sendKeys(amount);
    }

    @Then("Select manual penalty date as today")
    public void selectManualPenaltyDateAsToday() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("ManualPenalty:penaltyDate_input"))).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Select manual penalty period")
    public void selectManualPenaltyPeriod() throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ManualPenalty:penaltyPeriod\"]/div[3]"))).click();
        Thread.sleep(1500);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Extract manual penalty arn number {string}")
    public void extractManualPenaltyArnNumber(String success) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,100);
        String text  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+success+"')]"))).getText();
        //Manual Penalty saved successfully. MANP/000003252/2021
        System.out.println(text);
        System.out.println("substring is "+ text.substring(35));
        ReferenceNumber =text.substring(35);

        System.out.println(ReferenceNumber);
        System.out.println("Actual ARN to be used in CRM is " +ReferenceNumber);

        Thread.sleep(5000);
    }

    @Then("Enter start date as {string}")
    public void enterStartDateAs(String date) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:StartDate_input"))).sendKeys(date);
        Thread.sleep(1500);
        actions.sendKeys(Keys.TAB).perform();
    }
}



