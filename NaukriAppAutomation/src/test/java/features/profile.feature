
@home
Feature: Naukri Application Home Page Functionalities
  
	
  Scenario: Edit Carrer Profile
    Given I naviagte to my profile
    And Click on carrer profile
    When I click on "preffered location", select/deslect a "location"
    And clcik on save button
    Then I should see profile updated as "Today"