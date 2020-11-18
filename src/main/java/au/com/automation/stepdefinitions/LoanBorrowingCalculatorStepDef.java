package au.com.automation.stepdefinitions;

import au.com.automation.helper.Logger;
import au.com.automation.helper.WaitHelper;
import au.com.automation.pages.TestBase;
import au.com.automation.pages.loanBorrowingCalculator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoanBorrowingCalculatorStepDef extends TestBase {
   loanBorrowingCalculator borrowerCalc = new loanBorrowingCalculator(driver);
    WaitHelper waitHelper = new WaitHelper(driver);

    org.apache.log4j.Logger log = Logger.getLogger(LoanBorrowingCalculatorStepDef.class);
    @Given("User navigates to Application URL")
    public void userNavigatesToApplicationURL() throws InterruptedException {
        borrowerCalc.navigateToURL();
    }

    @When("^User provide the following details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void userProvideDetails(String arg0, int arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) throws Throwable {
        borrowerCalc.enterDetails(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    }

    @And("^click on 'Work out how much I could borrow' button$")
    public void clickButtonWorkOutHowMuchICouldBorrow() {

        borrowerCalc.clickOnEstimateBtn();
    }

    @Then("^User should see borrowing estimates \"([^\"]*)\"$")
    public void userShouldSeeBorrowingEstimates(String estimatedAmount) throws Throwable {

        borrowerCalc.verifyEstimatedAmount(estimatedAmount);
    }

    @And("^click on Start over button$")
    public void clickOnStartOverButton() {

        borrowerCalc.clickStartOverBttn();
    }

    @Then("^User should see the empty form$")
    public void userShouldSeeTheEmptyForm() {

        borrowerCalc.verifyEmptyForm();
    }

}
