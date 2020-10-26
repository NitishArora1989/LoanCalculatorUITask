package au.com.automation.pages;

import au.com.automation.helper.Constants;
import au.com.automation.helper.WaitHelper;
import au.com.automation.pageObjects.homeLoanPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class borrowerCalulator {
    private WebDriver driver;
    WaitHelper waitHelper;
    public borrowerCalulator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);

    }


    public void navigateToURL(){
        driver.get(Constants.mainUrl);

    }

    public void enterIncomeDetails(String applicationType, int dependants, String propertyType, String income, String otherIncome, String livingExpenses, String homeLoanRepayments, String otherLoan, String otherCommitment, String totalCredit) throws InterruptedException {
        waitHelper = new WaitHelper(driver);
        // Enter the user details
        Thread.sleep(8000);
        if(applicationType.equals("Single"))
        {
            homeLoanPageObjects.applicationTypeSingle(driver).click();
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

    public void clickEstimateBtn(){
        homeLoanPageObjects.estimateBorrowerBtn(driver).click();
        //driver.findElement(By.xpath("//*[@id='btnBorrowCalculater']")).click();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void verifyEstimateAmount(String estimateAmount){
        String updatedactualAmount =null;
        String actualAmount = homeLoanPageObjects.estimatedAmount(driver).getText();
        System.out.println("value of Actual Amount"+ actualAmount);
      if(actualAmount.contains("$")){
            updatedactualAmount = actualAmount.replace("$", "");

            System.out.println("Updated value of Actual Amount"+ updatedactualAmount);
        }
        //float borrowingEstimate=Float.parseFloat(updatedactualAmount);
        Assert.assertEquals(estimateAmount,updatedactualAmount, "Estimate Borrowing Amount");
    }

    public void clickStartOverBtn() {
        homeLoanPageObjects.startOver(driver).click();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyBlankForm() {
        String incomeAmount = homeLoanPageObjects.income(driver).getText();
         String newIncomeAmount = incomeAmount.replace("$","");
        Assert.assertEquals(newIncomeAmount,"", "Value should be blank");

    }
}
