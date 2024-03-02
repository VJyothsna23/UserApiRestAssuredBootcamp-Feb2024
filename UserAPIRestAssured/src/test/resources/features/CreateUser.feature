@UserModule, @UserModule-Post
Feature: User API Module - POST Create Requests

  @POST_user_01
  Scenario: Authorized user able to create new user with valid Url,end point,request body
    Given Authorized User sets request with valid Url,valid endpoint and valid request body
    When User sends POST request
    Then User receives 201 OK Status and valid response in response body   
   
  @POST_user_03
  Scenario: User should not be able to create new user with valid Url,request body and invalid end point
    Given User sets request for with valid Url, invalid endpoint and valid request body
    When User sends POST request
    Then User receives 404 Not found status in response body

  @POST_user_04
  Scenario: User should not be able to create new user with invalid Url and valid request body, end point
    Given User sets request for with invalid Url, valid endpoint and valid request body
    When User sends POST request
    Then User receives 404 Not found status in response body

  @POST_user_06-41
  Scenario Outline: Authorized user able to create new user with valid Url,end point,request body with mandetory fields
    Given Authorized User sets Post request with valid Url,valid endpoint, request body with "<TestCaseNumber>" and "<Sheetname>" from excel
    When User sends POST request
    Then User receives "<Status code>" in response body.

    Examples: 
      | TestCaseNumber | Sheetname    | Status code |
      | User_Post_01   | AllPostTests |         201 |
      | User_Post_06   | AllPostTests |         400 |
      | User_Post_07   | AllPostTests |         400 |
      | User_Post_08   | AllPostTests |         400 |
      | User_Post_09   | AllPostTests |         400 |
      | User_Post_10   | AllPostTests |         400 |
      | User_Post_11   | AllPostTests |         400 |
      | User_Post_13   | AllPostTests |         400 |
      | User_Post_14   | AllPostTests |         400 |
      | User_Post_15   | AllPostTests |         400 |
      | User_Post_16   | AllPostTests |         201 |
      | User_Post_17   | AllPostTests |         400 |
      | User_Post_18   | AllPostTests |         400 |
      | User_Post_19   | AllPostTests |         400 |
      | User_Post_20   | AllPostTests |         201 |
      | User_Post_21   | AllPostTests |         400 |
      | User_Post_22   | AllPostTests |         400 |
      | User_Post_23   | AllPostTests |         400 |
      | User_Post_24   | AllPostTests |         400 |
      | User_Post_25   | AllPostTests |         400 |
      | User_Post_26   | AllPostTests |         400 |
      | User_Post_28   | AllPostTests |         400 |
      | User_Post_29   | AllPostTests |         400 |
      | User_Post_30   | AllPostTests |         400 |
      | User_Post_31   | AllPostTests |         400 |
      | User_Post_32   | AllPostTests |         400 |
      | User_Post_33   | AllPostTests |         400 |
      | User_Post_34   | AllPostTests |         400 |
      | User_Post_35   | AllPostTests |         400 |
      | User_Post_36   | AllPostTests |         400 |
      | User_Post_37   | AllPostTests |         400 |
      | User_Post_38   | AllPostTests |         400 |
      | User_Post_39   | AllPostTests |         400 |
      | User_Post_40   | AllPostTests |         409 |
      | User_Post_41   | AllPostTests |         409 |
