@Login-Purchase
  Feature: Login - Purchase
    As a user, i want purchase one of the product

  Scenario: Login, Adding 2 item to cart, Remove 1 from cart and then finish the checkout process
    Given User open the web sauce demo
    When User input "standard_user" as userName and "secret_sauce" as password and click login
    Then User already on dashboard page
    When User sort product by "Price (low to high)"
    And User click add to cart item "Sauce Labs Onesie"
    And User click add to cart item "Sauce Labs Bike Light"
    And User click shopping cart badge
    And User remove Sauce Labs Bike Light from shopping cart
    And user click Checkout button
    Then User redirected to Checkout Step One page
    When User input "Oji" as Firstname "Ganteng" as Lastname "123123" as Zipcode
    And User click Continue button
    Then User redirected to Checkout Step Two page
    When User click Finish button
    Then User redirected to Checkout Complete page

