
Feature: Tests pets
			
	@test_1
		Scenario Outline: Validar test
			Given Post Pet Payload with "<id>", "<name>", "<status>"
			When user calls "postPetAPI" with "POST" http request
			Then the API call got success with status code 200
			And "name" in response body is "<name>"
			Then verify name created maps to "<name>" using "getPetAPI" and id "<id>"
			Then the API call got success with status code 200
			And "name" in response body is "<name>"
			Then UpdatePet id "<id>" after being created via api with new values "rocky","available"
			When user calls "putPetAPI" with "PUT" http request
			Then the API call got success with status code 200
			And "name" in response body is "rocky"
		
		Examples:
			|id  | name |status 	|
			|1004		 | percherito	 		|available			|