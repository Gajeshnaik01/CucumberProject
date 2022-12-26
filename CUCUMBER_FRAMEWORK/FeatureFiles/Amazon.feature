Feature: check the search feature
	@smoke @reg
  Scenario: search the product in search text box
    Given User must be in Amazon Page
    When Enter the product name in search textbox
    And click on Search Btn and click on first Product
    Then validate the product page is displayed

    @reg
  Scenario: search the product in search text box
    Given User must be in Amazon Page
    When Enter the product name in search textbox
    And click on Search Btn and click on first Product
    Then validate the product page is displayed