  Feature: login
    Scenario: successful login
      Given the profile button is clicked
      When I login as epam/1234
      Then submit form with 'true' argument