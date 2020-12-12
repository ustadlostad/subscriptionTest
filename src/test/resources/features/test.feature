Feature: Subscription

  Scenario: Digiturk Sub

    Given user is on landing page
      And user click subscription button
    Then user is navigated to the subs

    Given user is on sub page
      Then page contains two week free trial
      Then validate package price
      And user clicks sub button
    Then user is navigated to Account Page

    Given user is on Account Page
      When user enters name surname email password
      And clicks create account button
    Then user is navigated to payment method page

    Given user is on payment method page
      And user checks Terms and Conditions Button
      And pay now button is clickable
      And user clicks pay now button
    Then user is navigated to order page

    Given user is on order page
      When charge is 1.00
      And user enters name
      And user enters card number
      And user enters expiry date
      And user enters verf code
      And user clicks confirm button
    Then page gives error

