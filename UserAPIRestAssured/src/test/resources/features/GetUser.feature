@UserModule, @UserModule-Get
Feature: User API Module - Get All users, UserID and First Name

  @Get_All_Users_01
  Scenario: Authorized user able to view all users
    Given Authorized User creates the GET request with valid baseUrl,valid endpoint
    When User sends GET request
    Then User receives 200 OK Status in response body

  @Get_All_Users_02
  Scenario: Authorized user should not be able to view all users with valid endpoint and invalid url
    Given Authorized User creates the GET request with invalid baseUrl,valid endpoint
    When User sends GET request
    Then User receives 404 Not found Status in response body

  @Get_All_Users_03
  Scenario: Authorized user should not be able to view all users with invalid endpoint and valid url
    Given Authorized User creates the GET request with valid baseUrl,invalid endpoint
    When User sends GET request
    Then User receives 404 Not found Status in response body

  @Get_All_Users_04
  Scenario: Unauthorized user not able to view all users
    Given Unauthorized User creates the GET request with valid baseUrl,valid endpoint
    When User sends GET request
    Then User receives 401 Unauthorized Status in response body

  @Get_user_by_ID_05
  Scenario: Authorized user able to view respective user with valid endpoint,valid url,valid id
    Given Authorized User creates the GET by ID request with valid baseUrl,valid endpoint ,valid id
    When User sends GET request
    Then User receives 200 OK Status in response body

  @Get_user_by_ID_06
  Scenario: Authorized user should not be able to view respective users with valid endpoint,invalid url,valid id
    Given Authorized User creates the GET by ID request with invalid baseUrl,valid endpoint ,valid id
    When User sends GET request
    Then User receives 404 Not found Status in response body

  @Get_user_by_ID_07
  Scenario: Authorized user should not be able to view respective users with invalid endpoint,valid url,valid id
    Given Authorized User creates the GET by ID request with valid baseUrl,invalid endpoint ,valid id
    When User sends GET request
    Then User receives 404 Not found Status in response body

  @Get_user_by_ID_08-15
  Scenario Outline: Authorized user should not be able to view respective user with valid endpoint,valid url,invalid id
    Given Authorized User creates the GET by ID request with valid baseUrl,valid endpoint, invalid id
    When User sends GET request with "<invalid id>"
    Then User receives "<status code>" Status in Get response body

    Examples: 
      | invalid id | status code |
      |   56567678 |         404 |
      |            |         404 |
      | 2n78hgt    |         400 |
      | 3&5^7*6    |         400 |
      | &^%$#^     |         500 |

  @Get_user_by_ID_16
  Scenario: Unauthorized user should not be able to view respective users with valid endpoint,valid url,valid id
    Given Unauthorized User creates the GET by ID request with valid baseUrl,valid endpoint ,valid id
    When User sends GET request
    Then User receives 401 Unauthorized Status in response body

  @Get_user_by_first_name_17
  Scenario: Authorized user able to view respective user with valid endpoint,valid url,valid firstname
    Given Authorized User creates the GET by FirstName request with valid baseUrl,valid endpoint ,valid firstname
    When User sends GET request
    Then User receives 200 OK Status in response body

  @Get_user_by_first_name_18
  Scenario: Authorized user should not be able to view respective users with valid endpoint,invalid url,valid firstname
    Given Authorized User creates the GET by FirstName request with invalid baseUrl,valid endpoint ,valid firstname
    When User sends GET request
    Then User receives 404 Not found Status in response body

  @Get_user_by_first_name_19
  Scenario: Authorized user should not be able to view respective users with invalid endpoint,valid url,valid firstname
    Given Authorized User creates the GET by FirstName request with valid baseUrl,invalid endpoint ,valid firstname
    When User sends GET request
    Then User receives 404 Not found Status in response body

  @Get_user_by_first_name_20-30
  Scenario Outline: Authorized user should not be able to view respective user with valid endpoint,valid url,invalid firstname
    Given Authorized User creates the GET by FirstName request with valid baseUrl,valid endpoint ,invalid firstname
    When User sends GET request with "<invalid FirstName>"
    Then User receives "<status code>" Status in Get response body

    Examples: 
      | invalid FirstName | status code |
      | dfghjkmn          |         404 |
      | 2n78hgt           |         404 |
      |          34567897 |         404 |
      | a&f^h%$           |         500 |
      |                   |         404 |
      | Jyot hsna Ve      |         404 |
      | jyoThsnAve        |         404 |

  @Get_user_by_first_name_31
  Scenario: Unauthorized user should not be able to view respective users with valid endpoint,valid url,valid firstname
    Given Unauthorized User creates the GET by FirstName request with valid baseUrl,valid endpoint ,valid firstname
    When User sends GET request
    Then User receives 401 Unauthorized Status in response body
