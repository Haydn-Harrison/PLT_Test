Feature: Testing

  Scenario: Verify that product description pages are opening
    Given I am on the PLT homepage
    When I select 'Clothing' in the nav menu
    Then the 'Product detail' page is opened

  Scenario: Verify that product information pages are opening
    Given I am on the 'Summer' page
    When I choose the product 'Plus Vintage High Waisted Denim Shorts'
    Then the 'Product information' page is opened

  Scenario: Verify that selecting a size sets the background colour to grey
    Given I am on the 'Summer' page
    When I choose the product 'Plus Vintage High Waisted Denim Shorts'
    And I pick the size '16'
    Then the background colour of the size icon changes to 'rgba(81, 81, 81, 1)'

  Scenario: Verify that adding an item to a bag updates the bag count
    Given I am on the 'Summer' page
    When I add the product 'Plus Vintage High Waisted Denim Shorts' in size '16' to my bag
    Then the bag quantity is correct
    And the added item is visible at the bottom of the bag list

  Scenario: Verify that the bag link takes the user to the bag page
    Given I am on the 'Summer' page
    When I add the product 'Plus Vintage High Waisted Denim Shorts' in size '16' to my bag
    And I click on the bag button
    Then the 'Bag' page is opened

  Scenario: Verify that the proceed to checkout button works
    Given I am on the 'Summer' page
    When I have a bag with the product 'Plus Vintage High Waisted Denim Shorts' in size '16' opened
    And I click proceed to checkout
    Then the 'Checkout' page is opened

  Scenario: Verify that the password field is displayed if a valid email is supplied on the checkout page
    Given I am on the 'Summer' page
    When I have a bag with the product 'Plus Vintage High Waisted Denim Shorts' in size '16' opened
    And I click proceed to checkout
    And I supply the 'email' 'plttesthaydn@gmail.com'
    Then the password field is displayed

  Scenario: Verify that the users firstname is displayed in the hey message if account sign in has been successful
    Given I am on the 'Summer' page
    When I have a bag with the product 'Plus Vintage High Waisted Denim Shorts' in size '16' opened
    And I click proceed to checkout
    And I supply the 'email' 'plttesthaydn@gmail.com'
    And I supply the 'password' 'Test123!'
    Then The firstname 'HaydnTest' is displayed in the hey message on the checkout screen

  Scenario: Verify that the bag subtotal and the checkout subtotal are the sameQ
    Given I am on the 'Summer' page
    When I have a bag with the product 'Plus Vintage High Waisted Denim Shorts' in size '16' opened
    And I click proceed to checkout and sign in with valid credentials
    Then the bag subtotal and the checkout subtotal are the same

  Scenario: Verify that selecting a payment method opens the pay window for that method
    Given I am on the 'Summer' page
    When I have a bag with the product 'Plus Vintage High Waisted Denim Shorts' in size '16' opened
    And I click proceed to checkout and sign in with valid credentials
    And I select the payment method 'Pay With Card'
    Then the pay by card window is displayed