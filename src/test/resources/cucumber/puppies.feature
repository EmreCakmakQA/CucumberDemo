Feature: Search on Google

Scenario: Searches for Puppies
	Given I can open Google
	When I search for puppies
	Then Google will give me Puppies