#Author: Koteswara Kolluri
Feature: To test the functionality of http://automationpractice.com/

  @ordertshirt
  Scenario Outline: To buy a T-Shirt and verify the order in order history details
    Given User launches the application "<URL>" in Browser "<Browser>" for testcase "<TestCase>"
    Then User should login with the account details with Username "<Username>" Password "<Password>"
    Then User should navigate TShirt Viewer page
    Then User should select TShirt with color "<TShirtColor>"
    Then User need to add payment "<PaymentMethod>" and confirm the order
    Then User need to verify the order
    Then User need to sigout of the application

    Examples: 
      | TestCase | URL                           | Browser | Username                | Password   | TShirtColor | PaymentMethod |
      | Test01   | http://automationpractice.com | Chrome  | myteknikmay12@gmail.com | Sachin1994 | Blue        | PAYBANKWIRE   |
      | Test02   | http://automationpractice.com | Chrome  | myteknikmay12@gmail.com | Sachin1994 | Orange      | PAYBYCHECK    |

  @updatepersonalinformation
  Scenario Outline: To update first name of the user
    Given User launches the application "<URL>" in Browser "<Browser>" for testcase "<TestCase>"
    Then User should login with the account details with Username "<Username>" Password "<Password>"
    Then User should navigate to personal information page
    Then User should update firstname "<FirstName>" Password "<Password>"
    Then User need to sigout of the application

    Examples: 
      | TestCase | URL                           | Browser | Username                | Password   | FirstName |
      | Test03   | http://automationpractice.com | Chrome  | myteknikmay12@gmail.com | Sachin1994 | Sachin    |
