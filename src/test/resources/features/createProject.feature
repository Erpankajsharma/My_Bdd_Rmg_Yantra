Feature: Create a project

  As a user of RMG YANTRA website
  I want to able to login with my account
  So that I can able to create a project

  Background:
    Given I am on the rmg yantra login page
    When I have entered valid username and password
    And I click on login button
    Then I should be logged in successfully
    When I click on projects feature
    Then List of projects page should be displayed

  @FunctionalTest
  Scenario Outline: create a project with passing valid data
    When I click on create project button
    And I enter project name "<Project Name>"
    And I enter project manager name "<Project Manager>"
    And I select project status "<Project Status>"
    And I click on addProject button
    Then I validate toast message "<Toast Message>"
    Then I validate the "<Project Name>" should be successfully created

    Examples:
      | Project Name | Project Manager | Project Status | Toast Message                       |
      | RMG_BDD      | Pankaj_         | Created        | Project RMG_BDD Successfuly Added   |
#      | RMG_BDD_1    | Pankaj_1        | On Going       | Project RMG_BDD_1 Successfuly Added |
#      | RMG_BDD_2    | Pankaj_2        | Completed      | Project RMG_BDD_2 Successfuly Added |

  @FunctionalTest
  Scenario Outline: delete a project with passing valid data
    When I click on delete button of a project "<Project Name>"
    Then I validate a delete project popup should be displayed
    When I click on delete button of the popup
    Then I validate toast message "<Toast Message>"
    Then I validate the project "<Project Name>" should be deleted successfully

    Examples:
      | Project Name | Toast Message                        |
      | RMG_BDD      | RMG_BDDProject Successfuly Deleted   |
#      | RMG_BDD_1    | RMG_BDD_1Project Successfuly Deleted |
#      | RMG_BDD_2    | RMG_BDD_2Project Successfuly Deleted |