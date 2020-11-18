package au.com.automation.pageObjects;

import au.com.automation.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homeLoanPageObjects {
    private static WebElement element = null;
    WaitHelper waitHelper;
public static By applicationtypeSingle =By.xpath("//*[@for='application_type_single']");
    public static WebElement applicationTypeSingle(WebDriver driver) {
        element = driver.findElement(applicationtypeSingle);
        return element;
    }
    public static WebElement applicationTypeJoint(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@for='application_type_joint']"));
        return element;
    }
    public static WebElement selectDependants(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@title='Number of dependants']"));
        return element;
    }
    public static WebElement propertyTypeLiveIn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@for='borrow_type_home']"));
        return element;
    }
    public static WebElement propertyTypeInvestment(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@for='borrow_type_home']"));
        return element;
    }

    public static WebElement income(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@aria-labelledby='q2q1']"));
        return element;
    }

    public static WebElement otherIncome(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@aria-labelledby='q2q2']"));
        return element;
    }

    public static WebElement livingExpenses(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@aria-labelledby='q3q1']"));
        return element;
    }

    public static WebElement homeLoanRepayments(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@aria-labelledby='q3q2']"));
        return element;
    }

    public static WebElement otherLoan(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@aria-labelledby='q3q3']"));
        return element;
    }
    public static WebElement otherCommitment(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@aria-labelledby='q3q4']"));
        return element;
    }
    public static WebElement totalCredit(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@aria-labelledby='q3q5']"));
        return element;
    }
    public static WebElement estimateBorrowerBtn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='btnBorrowCalculater']"));
        return element;
    }
    public static WebElement estimatedAmount(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id='borrowResultTextAmount']"));
        return element;
    }

    public static WebElement startOver(WebDriver driver) {
        element = driver.findElement(By.xpath("(//button[@class='start-over' and text()='Start over'])[1]"));
        return element;
    }


}
