
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Website
	
  @tag2
  Scenario Outline: Positive test of submitting order
    Given Logged in with <name> and password <password>
    When I add <productname> to cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on ComfirmationPage

    Examples: 
      | name               | password | productname  |
      | rahulshetty@gmail.com |Iamking@000|  ZARA COAT 3 | 
