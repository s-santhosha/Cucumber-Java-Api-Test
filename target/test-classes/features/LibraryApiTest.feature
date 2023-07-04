Feature: Library Book API Tests

  Scenario Outline: The user can query for the book using author
    When I query for the book using author parameter "<queryParameter>"
    Then the list of books are returned "<values>"
    Examples:
      | queryParameter | values          |
      | author         | Agatha Christie |


  Scenario Outline: The user can query for the book using title
    When I query for the book using title parameter "<queryParameter>"
    Then the list of books are returned "<values>"
    Examples:
      | queryParameter | values       |
      | title          | The Big Four |