@LoanCalculator
Feature: Loan Borrowing Calculator Functionality check

  Scenario Outline: User fetch the estimated amount after providing the relavent details
    Given User navigates to Application URL
    When User provide the following details "<Application type>","<Dependants>","<Property Type>","<Income>","<Other Income>","<Living Expenses>","<Other Home Repayment>","<Other Loan Repayment>","<Other Commitments>","<Total Credit>"
    And click on 'Work out how much I could borrow' button
    Then User should see borrowing estimates "<Estimate Amount>"
    Examples:
      |Application type|Dependants|Property Type  |Income |Other Income|Living Expenses|Other Home Repayment|Other Loan Repayment|Other Commitments|Total Credit|Estimate Amount|
      |Single          |0         |LiveIn         |80000  |10000       |500            |0                   |100                 |0                |10000       |500,000        |


  Scenario Outline: User get empty form after clicking start over button
    Given User navigates to Application URL
    When User provide the following details "<Application type>","<Dependants>","<Property Type>","<Income>","<Other Income>","<Living Expenses>","<Other Home Repayment>","<Other Loan Repayment>","<Other Commitments>","<Total Credit>"
    And click on 'Work out how much I could borrow' button
    And User should see borrowing estimates "<Estimate Amount>"
    And click on Start over button
    Then User should see the empty form
    Examples:
      |Application type|Dependants|Property Type  |Income |Other Income|Living Expenses|Other Home Repayment|Other Loan Repayment|Other Commitments|Total Credit|Estimate Amount|
      |Single          |0         |LiveIn         |80000  |10000       |500            |0                   |100                 |0                |10000       |500,000        |

