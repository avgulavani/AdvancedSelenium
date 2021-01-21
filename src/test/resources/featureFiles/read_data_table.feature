@DatatableExample
Feature: Understand Data table reading operation by list,map and transform method

  Scenario: @ByList Read datatable by list
    Given I have the following books in the store by list
      | The Devil in the White City | Erik Larson |

  Scenario: @ByMap Read datatable by Map
    Given I have the following books in the store by map
      | title                                | author     |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis |

  Scenario: @ByTransform Read datatable by Transofrm
    Given I have the following books in the store by Transform
      | title                   | author      |
      | In the Garden of Beasts | Erik Larson |
