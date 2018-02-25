Feature: Sales And Lettings Test Case
As a user of right move
I should be able to search for sales properties
And sort for newly listed properties to select non-featured property

Scenario Outline: Select non-featured newly listed property for Sale
  Given I have launched rightmove website
  When I carry out a search for properties for "sale" based on "<keyword>"
  And I select various "<filters>" in the dropdown and click on find properties
  And I change the sort order to "Newest Listed" properties
  Then I should be able to select the first non-featured property
  And I verify the values

  Examples:
  |keyword          | filters                                                         |
  | greenhithe,kent | This area only:Any:No min:No max:No min:No max:Anytime:false    |


  Scenario Outline: Select non-featured lowest price property for Rent
    Given I have launched rightmove website
    When I carry out a search for properties for "rent" based on "<keyword>"
    And I select various "<filters>" in the dropdown and click on find properties
    And I change the sort order to "Lowest Price" properties
    Then I should be able to select the first non-featured property for rental
    And I verify the values

    Examples:
      |keyword          | filters                                                         |
      | greenhithe,kent | This area only:Any:No min:No max:No min:No max:Anytime:false    |