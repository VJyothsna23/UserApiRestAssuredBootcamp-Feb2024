@UserModule, @UserModule-Delete
Feature: User API Module - DELETE Users by user ID and First Name
#
  #@Delete_user_by_userID_02-05
  #Scenario Outline: User able to delete the user with valid url, end point by invalid user ID
    #Given Authorized User sets request with valid Url,valid endpoint by invalid user ID
    #When User sends DELETE request with valid Url,valid endpoint, with "<invalid id>"
    #Then User receives "<status code>" Status in response body
#
    #Examples: 
      #| invalid id | status code |
      #|   56567678 |         404 |
      #|            |         404 |
      #| 2n78hgt    |         400 |
      #| 3&5^7*6    |         400 |
      #| &^%$#^     |         500 |
#
  #@Delete_user_by_userID_06a
  #Scenario: User able to delete the user with invalid url, valid end point by valid user ID
    #Given Authorized User sets request with invalid Url, valid endpoint by valid user ID
    #When User sends DELETE request
    #Then User receives 404 Not found  Status in response body
#
  #@Delete_user_by_userID_06b
  #Scenario: User able to delete the user with valid url, invalid end point by valid user ID
    #Given Authorized User sets request with valid Url, invalid endpoint by valid user ID
    #When User sends DELETE request
    #Then User receives 404 Not found  Status in response body
#
  #@Delete_user_by_userID_07
  #Scenario: Unauthorized user able to delete the user with valid url, end point by valid user ID
    #Given Unauthorized User sets request with valid Url,valid endpoint by valid user ID
    #When User sends DELETE request
    #Then User receives 401 Unauthorized  Status in response body
#
  #@Delete_user_by_firstname_09-13
  #Scenario Outline: User not able to delete the user with valid url, valid end point, and invalid user first name
    #Given Authorized User sets request with valid Url,valid endpoint by invalid user first name
    #When User sends DELETE request with valid Url,valid endpoint, with "<invalid FirstName>"
    #Then User receives "<status code>" Status in response body
#
    #Examples: 
      #| invalid FirstName | status code |
      #| invalid FirstName |         404 |
      #| dfghjkmn          |         404 |
      #|          34567897 |         404 |
      #| a&f^h%$           |         500 |
      #|                   |         400 |
      #| Jyot hsna Ve      |         404 |
      #| jyoThsnAve        |         404 |
#
  #@Delete_user_by_firstname_14
  #Scenario: User not able to delete the user with invalid url, end point by valid user first name
    #Given Authorized User sets request with invalid Url,valid endpoint by valid user first name
    #When User sends DELETE request
    #Then User receives 400 Not found  Status in response body
#
  #@Delete_user_by_firstname_15
  #Scenario: User not able to delete the user with valid url, invalid end point by valid user first name
    #Given Authorized User sets request with valid Url, invalid endpoint by valid user first name
    #When User sends DELETE request
    #Then User receives 400 Not found  Status in response body
#
  #@Delete_user_by_firstname_16
  #Scenario: Unauthorized user not able to delete the user with valid url, valid end point, and valid user first name
    #Given Unauthorized User sets request with valid Url,valid endpoint by valid user first name
    #When User sends DELETE request
    #Then User receives 401 Unauthorized  Status in response body
    
  @Delete_user_by_userID_01
  Scenario: Authorized user able to delete the user with valid url, end point by valid user ID
    Given Authorized User sets request with valid Url,valid endpoint by valid user ID
    When User sends DELETE request with valid ID
    Then User receives 200 OK  Status in response body
    
  @Delete_user_by_firstname_08
  Scenario: Authorized user able to delete the user with valid url, valid end point, valid user first name
    Given Authorized User sets request with valid Url,valid endpoint and valid user first name
    When User sends DELETE request with valid FirstName
    Then User receives 200 OK  Status in response body
