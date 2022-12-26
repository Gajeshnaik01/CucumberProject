Feature: check the search feature
	@smoke
  Scenario: search the product in search text box
    Given User must be in Amazon Page
    When Enter the product name in search textbox
    And click on Search Btn and click on first Product
    Then validate the product page is displayed

@tc001
Scenario Outline: search the product in search text box
    Given User must be in Amazon Page
    When search for "<mobiles>"
    Then click on any mobile
    
Examples:
|mobiles|
|samsung|

