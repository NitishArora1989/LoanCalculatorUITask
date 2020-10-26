@borrower
Feature:
  As a  user
  I want to test borrower calculator for my home applications


  @sanity
  Scenario Outline: User get the loan borrowing estimation
    Given User navigates to Application URL
    #When I enter the following details "<Application type>","<Dependants>","<Property Type>","<Income>","<Other Income>","<Living Expenses>"<string>"<Other Home Repayment>"<string>"<Other Loan Repayment>"<string>"<Other Commitments>"<string>"<Total Credit>"
    When I enter the following details "<Application type>" , "<Dependants>" , "<Property Type>", "<Income>" , "<Other Income>", "<Living Expenses>", "<Other Home Repayment>", "<Other Loan Repayment>" , "<Other Commitments>" , "<Total Credit>"
    And I click button 'work out how much I could borrow'
    Then I should see borrowing estimates "<Estimate Amount>"


    Examples:
      |Application type|Dependants|Property Type  |Income |Other Income|Living Expenses|Other Home Repayment|Other Loan Repayment|Other Commitments|Total Credit|Estimate Amount|
      |Single          |0         |LiveIn         |80000  |10000       |500            |0                   |100                 |0                |10000       |486,000        |


  Scenario Outline: User get blank form after start over click
    Given User navigates to Application URL
    #When I enter the following details "<Application type>","<Dependants>","<Property Type>","<Income>","<Other Income>","<Living Expenses>"<string>"<Other Home Repayment>"<string>"<Other Loan Repayment>"<string>"<Other Commitments>"<string>"<Total Credit>"
    When I enter the following details "<Application type>" , "<Dependants>" , "<Property Type>", "<Income>" , "<Other Income>", "<Living Expenses>", "<Other Home Repayment>", "<Other Loan Repayment>" , "<Other Commitments>" , "<Total Credit>"
    And I click button 'work out how much I could borrow'
    And I should see borrowing estimates "<Estimate Amount>"
    And I click on Start over button
    Then I should see the blank form.



    Examples:
      |Application type|Dependants|Property Type  |Income |Other Income|Living Expenses|Other Home Repayment|Other Loan Repayment|Other Commitments|Total Credit|Estimate Amount|
      |Single          |0         |LiveIn         |80000  |10000       |500            |0                   |100                 |0                |10000       |486,000        |

