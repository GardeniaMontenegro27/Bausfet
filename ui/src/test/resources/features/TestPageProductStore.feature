@Smoke

Feature: Product Store

Scenario: Product in cart successful 
Given I open the Product Store
When Login to the Product Store with the Username and Password
Then I add a laptop to the cart
Then I validate that the product is in the shopping cart
Then Close session

