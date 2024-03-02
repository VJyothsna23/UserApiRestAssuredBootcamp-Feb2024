@UserModule, @UserModule-Put
Feature: User API Module - POST Create Requests

  @PuT_user_03
  Scenario: User should not be able to update new user with valid Url,request body and invalid end point
    Given User sets PUT request for with valid Url, invalid endpoint and valid request body
    When User sends PUT request
    Then User receives 404 status in response body

  @PuT_user_04
  Scenario: User should not be able to update new user with invalid Url and valid request body, end point
    Given User sets PUT request for with invalid Url, valid endpoint and valid request body
    When User sends PUT request
    Then User receives 404 status in response body

  @PUT_user_invalid_ID
  Scenario Outline: Authorized user able to update user with valid Url,end point,request body,invalid user ID
    Given Authorized User sets PUT request with valid Url,valid endpoint,request body with invalid user ID, "<TestCaseNumber>" and "<Sheetname>" from excel
    When User sends PUT request with "<invalid id>"
    Then User receives "<Status Code>" in the response body.

    Examples: 
      | TestCaseNumber | Sheetname   | Status Code | invalid id |
      | User_Put_40    | AllPutTests |         404 |   56567678 |
      | User_Put_40    | AllPutTests |         404 |            |
      | User_Put_40    | AllPutTests |         400 | 2n78hgt    |
      | User_Put_40    | AllPutTests |         400 | 3&5^7*6    |
      | User_Put_40    | AllPutTests |         500 | &^%$#^     |

  @PUT_user_01,06-41
  Scenario Outline: Authorized user able to update user with valid Url,end point,request body, user ID
    Given Authorized User sets PUT request with valid Url,valid endpoint, request body with "<TestCaseNumber>" and "<Sheetname>" from excel
    When User sends PUT request
    Then User receives "<Status Code>" in the response body.

    Examples: 
      | TestCaseNumber | Sheetname   | Status Code |
      | User_Put_01    | AllPutTests |         200 |
      | User_Put_06    | AllPutTests |         400 |
      | User_Put_07    | AllPutTests |         400 |
      | User_Put_08    | AllPutTests |         400 |
      | User_Put_09    | AllPutTests |         400 |
      | User_Put_10    | AllPutTests |         400 |
      | User_Put_11    | AllPutTests |         400 |
      | User_Put_13    | AllPutTests |         400 |
      | User_Put_14    | AllPutTests |         400 |
      | User_Put_15    | AllPutTests |         400 |
      | User_Put_16    | AllPutTests |         200 |
      | User_Put_17    | AllPutTests |         400 |
      | User_Put_18    | AllPutTests |         400 |
      | User_Put_19    | AllPutTests |         400 |
      | User_Put_20    | AllPutTests |         200 |
      | User_Put_21    | AllPutTests |         400 |
      | User_Put_22    | AllPutTests |         400 |
      | User_Put_23    | AllPutTests |         400 |
      | User_Put_24    | AllPutTests |         400 |
      | User_Put_25    | AllPutTests |         400 |
      | User_Put_26    | AllPutTests |         400 |
      | User_Put_28    | AllPutTests |         400 |
      | User_Put_29    | AllPutTests |         400 |
      | User_Put_30    | AllPutTests |         400 |
      | User_Put_31    | AllPutTests |         400 |
      | User_Put_32    | AllPutTests |         400 |
      | User_Put_33    | AllPutTests |         400 |
      | User_Put_34    | AllPutTests |         400 |
      | User_Put_35    | AllPutTests |         400 |
      | User_Put_36    | AllPutTests |         400 |
      | User_Put_37    | AllPutTests |         400 |
      | User_Put_38    | AllPutTests |         400 |
      | User_Put_39    | AllPutTests |         400 |
