Feature: get book
  Scenario: Check if book exist
    Given there are some books in the library
    When I search for book with title started with "toto"
    Then The result should Be true
