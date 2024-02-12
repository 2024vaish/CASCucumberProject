Feature: News Verification

  Scenario: Verify News
    Given the user is on News Page
    And user verifies the news headings
    When user clicks on news header
    Then the user should be redirected to the next page
    And user should capture the news details
