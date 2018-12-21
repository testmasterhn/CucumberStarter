Feature: Login lazada with facebook account

Scenario: Show facebook for social login login
	Given I am staying at Lazada login page
	When I click on facebook login button
	Then I should see the facebook login windows

Scenario: Show lazada profile for social logged in
	Given I am taying at facebook login page
	When I provide my credential 
	Then I should see My profile on lazada page
