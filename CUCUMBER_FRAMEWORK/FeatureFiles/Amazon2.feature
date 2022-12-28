Feature: check the search feature1

  @reg
  Scenario: search the product in search text box1
    Given User must be in Amazon Page
    When Enter the product name in search textbox
    And click on Search Btn and click on first Product
    Then validate the product page is displayed

  @tc002
  Scenario: search the product in search text box1
    Given User must be in Amazon Page
    When search for mobiles
      | mobiles |
      | samsung |
    Then click on any mobile
