
Feature: Validate the YesBank
 

  @idfc @idfcscenario
  Scenario: validate the Account number
    Given User must be in IDFC Home Page
    When User open the Account list and click ok
    And click on Account Number 
    Then validate the Account Number
   
