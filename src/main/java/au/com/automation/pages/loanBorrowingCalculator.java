package au.com.automation.pages;

import au.com.automation.helper.Constants;
import au.com.automation.helper.WaitHelper;
import au.com.automation.pageObjects.homeLoanPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class loanBorrowingCalculator {
    private WebDriver driver;
    WaitHelper waitHelper;

    public loanBorrowingCalculator(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);

    }

    public void navigateToURL(){
        driver.get(Constants.mainUrl);

    }

    public void enterDetails(String applicationType, int dependants, String propertyType, String income, String otherIncome, String livingExpenses, String homeLoanRepayments, String otherLoan, String otherCommitment, String totalCredit) throws InterruptedException {
        waitHelper = new WaitHelper(driver);

        if(applicationType.equals("Single"))
        {
            waitHelper.FluentWait(homeLoanPageObjects.applicationtypeSingle ,20,5).click();
        }
        else{
            homeLoanPageObjects.applicationTypeJoint(driver).click();
        }

        WebElement dependent= homeLoanPageObjects.selectDependants(driver);

        Select dropdown = new Select(dependent);
        dropdown.selectByIndex(dependants);
        if(propertyType.equals("LiveIn")){
            homeLoanPageObjects.propertyTypeLiveIn(driver).click();
        }
        else
        {
            homeLoanPageObjects.propertyTypeInvestment(driver).click();
        }
        homeLoanPageObjects.income(driver).sendKeys(income);
        homeLoanPageObjects.otherIncome(driver).sendKeys(otherIncome);
        homeLoanPageObjects.livingExpenses(driver).sendKeys(livingExpenses);
        homeLoanPageObjects.homeLoanRepayments(driver).sendKeys(homeLoanRepayments);
        homeLoanPageObjects.otherLoan(driver).sendKeys(otherLoan);
        homeLoanPageObjects.otherCommitment(driver).sendKeys(otherCommitment);
        homeLoanPageObjects.totalCredit(driver).sendKeys(totalCredit);

    }

    public void clickOnEstimateBtn(){
        homeLoanPageObjects.estimateBorrowerBtn(driver).click();

    }
    public void verifyEstimatedAmount(String estimateAmount){
        String updatedactualAmount =null;
        String actualAmount = null;
        for (int i=0; i <100; i++)
        {
            actualAmount = homeLoanPageObjects.estimatedAmount(driver).getText();
            if(actualAmount == updatedactualAmount){
                break;
            }
            else {
                updatedactualAmount = actualAmount;
            }
        }
        System.out.println("value of Actual Amount"+ actualAmount);
        if(actualAmount.contains("$")){
            updatedactualAmount = actualAmount.replace("$", "");

            System.out.println("Updated value of Actual Amount"+ updatedactualAmount);
        }
        //float borrowingEstimate=Float.parseFloat(updatedactualAmount);
        Assert.assertEquals(estimateAmount,updatedactualAmount, "Estimate Borrowing Amount");
    }

    public void clickStartOverBttn() {
        homeLoanPageObjects.startOver(driver).click();

    }

    public void verifyEmptyForm() {
        String incomeAmount = homeLoanPageObjects.income(driver).getText();
         String newIncomeAmount = incomeAmount.replace("$","");
        Assert.assertEquals(newIncomeAmount,"", "Value should be blank");

    }
}
