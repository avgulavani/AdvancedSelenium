@brandnames
Feature: As a customer i should see all brand names

  Scenario: Compare all brand values are displayed correctly for product
    Given Open and launch the application
    When I Should see following brands for product
      | SAVYA HOME      |
      | Green Soul      |
      | Da URBAN        |
      | AmazonBasics    |
      | INNOWIN         |
      | MBTC            |
      | Wipro Furniture |
      
