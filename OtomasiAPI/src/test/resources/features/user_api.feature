Feature: User API

  Scenario: Get user data successfully
    Given user service is available
    When user sends request get user
    Then response status code should be 200
