Feature: Order Mens Jacket

  @test
  Scenario: 1 - Search for Jacket
    Given I am on Luma testing application
    When  I select the menu as Men > Jackets
    Then  I should be able to view the list of jackets available
    When  I click on the jacket type "Proteus Fitness Jackshirt"
    And   I select the size as "XL", color as "Blue" and quantity 1
    And   I click on 'Add to Cart' button
    Then  Product item must be successfully added to the cart
    
  #@test
  #Scenario: 2 - Select Jacket and Order
    #When  I click on the jacket type "Proteus Fitness Jackshirt"
    #And   I select the size as "XL", color as "Blue" and quantity 1
    #And   I click on 'Add to Cart' button
    #Then  Product item must be successfully added to the cart
