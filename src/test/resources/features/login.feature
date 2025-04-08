Feature: Login functionality for RMG YANTRA website

  As a user of RMG YANTRA website
  I want to able to login with my account
  So that I can access my account related feature and manage my projects

  @SmokeTest
    Scenario: successfull login with valid credentials
      Given I am on the rmg yantra login page
      When I have entered valid username and password
      And I click on login button
      Then I should be logged in successfully
