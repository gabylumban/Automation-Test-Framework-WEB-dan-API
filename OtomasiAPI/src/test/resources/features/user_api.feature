Feature: Reqres User API Tests

  Scenario: Get valid user
    Given I send GET request to get user with id 2
    Then Response status should be 200
    And Response body should contain "id"
    And Response body should contain "email"

  Scenario: Get invalid user
    Given I send GET request to get user with id 23
    Then Response status should be 404

  Scenario: Get valid users page
    Given I send GET request to get users page 2
    Then Response status should be 200
    And Response body should contain "data"

  Scenario: Get boundary page 0
    Given I send GET request to get users page 0
    Then Response status should be 200
    And Response body should contain "data"
