Feature: Category Details API

  @Positive
  Scenario: Verify Category Details API response with valid data
    Given I send a GET request to the Category Details API
    Then the response status code should be 200
    And the response body should contain Name as "Carbon credits"
    And the response body should contain CanRelist as true
    And the Promotions element with Name "Gallery" should have Description containing "Good position in category"

  @Negative
  Scenario: Verify Category Details API response with invalid Category ID
    Given I send a GET request to the Category Details API with invalid Category ID
    Then the response status code should not be 200
    And the response body should contain an error message

  @Negative
  Scenario: Verify Category Details API response with invalid query parameter
    Given I send a GET request to the Category Details API with invalid query parameter
    Then the response status code should not be 200
    And the response body should contain an error message