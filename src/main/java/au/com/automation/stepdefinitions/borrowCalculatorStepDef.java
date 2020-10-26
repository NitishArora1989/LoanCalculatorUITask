package au.com.automation.stepdefinitions;

import au.com.automation.helper.LoggerHelper;
import au.com.automation.helper.WaitHelper;
import au.com.automation.pages.TestBase;
import au.com.automation.pages.borrowerCalulator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class borrowCalculatorStepDef extends TestBase {
   borrowerCalulator borrowerCalulator1 = new borrowerCalulator(driver);
    WaitHelper waitHelper = new WaitHelper(driver);

    Logger log = LoggerHelper.getLogger(borrowCalculatorStepDef.class);
    @Given("User navigates to Application URL")
    public void userNavigatesToApplicationURL() throws InterruptedException {
        borrowerCalulator1.navigateToURL();
       // borrowerCalulator1.enterIncomeDetails("Single","0");
    }

    @When("^I enter the following details \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
    public void iEnterTheFollowingDetails(String arg0, int arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        borrowerCalulator1.enterIncomeDetails(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    }

    @And("^I click button 'work out how much I could borrow'$")
    public void iClickButtonWorkOutHowMuchICouldBorrow() {
        borrowerCalulator1.clickEstimateBtn();
    }
    //@When("^I should see borrowing estimates \"([^\"]*)\"$")
    @Then("^I should see borrowing estimates \"([^\"]*)\"$")
    public void iShouldSeeBorrowingEstimates(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        borrowerCalulator1.verifyEstimateAmount(arg0);
    }

    @And("^I click on Start over button$")
    public void iClickOnStartOverButton() {
        borrowerCalulator1.clickStartOverBtn();
    }

    @Then("^I should see the blank form\\.$")
    public void iShouldSeeTheBlankForm() {
        borrowerCalulator1.verifyBlankForm();
    }

   /* @When("^I enter the following details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",<Other Income>\"([^\"]*)\"<Living Expenses>\"([^\"]*)\"<Other Home Repayment>\"([^\"]*)\"<Other Loan Repayment>\"([^\"]*)\"<Other Commitments>\"([^\"]*)\"<Total Credit>\"$")
    public void iEnterTheFollowingDetailsOtherIncomeLivingExpensesOtherHomeRepaymentOtherLoanRepaymentOtherCommitmentsTotalCredit(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {
        borrowerCalulator1.enterIncomeDetails(arg0,arg1);
    }*/

 /*   @When("I enter the following details {string},{string},{string},{string},<Other Income>{string}<Living Expenses>{string}<Other Home Repayment>{string}<Other Loan Repayment>{string}<Other Commitments>{string}<Total Credit>\"")
    public void iEnterTheFollowingDetailsOtherIncomeLivingExpensesOtherHomeRepaymentOtherLoanRepaymentOtherCommitmentsTotalCredit(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        borrowerCalulator1.enterIncomeDetails(arg0,arg1);
    }*/

   /* @And("I click button {string}")
    public void iClickButtonWorkOutHowMuchICouldBorrow() {
    }

    @Then("I should see borrowing estimates")
    public void iShouldSeeBorrowingEstimates() {
    }*/
}
