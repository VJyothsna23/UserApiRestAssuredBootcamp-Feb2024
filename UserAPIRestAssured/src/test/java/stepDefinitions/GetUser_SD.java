package stepDefinitions;

import endPoints.AssignEndPoints;
import endPoints.Routes;
import endPoints.Tests;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetUser_SD {
	
	 RequestSpecification request;
	 Response response;
	 ValidatableResponse valid_response;
	
	@Given("Authorized User creates the GET request with valid baseUrl,valid endpoint")
	public void authorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUsers_Url);	
	}

	@When("User sends GET request")
	public void user_sends_get_request() {
		this.response = AssignEndPoints.getGetResponse(request);

	}

	@Then("User receives {int} OK Status in response body")
	public void user_receives_ok_status_in_response_body(Integer int1) {
		Tests.GetPositiveValidation(response);
	}

	@Given("Authorized User creates the GET request with invalid baseUrl,valid endpoint")
	public void authorized_user_creates_the_get_request_with_invalid_base_url_valid_endpoint() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUsers_InvalidUrl);
	}

	@Then("User receives {int} Not found Status in response body")
	public void user_receives_not_found_status_in_response_body(Integer int1) {
		Tests.GetNegative404Validation(response);
	}

	@Given("Authorized User creates the GET request with valid baseUrl,invalid endpoint")
	public void authorized_user_creates_the_get_request_with_valid_base_url_invalid_endpoint() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUsers_InvalidEP);
	}

	@Given("Unauthorized User creates the GET request with valid baseUrl,valid endpoint")
	public void unauthorized_user_creates_the_get_request_with_valid_base_url_valid_endpoint() {
		this.request = AssignEndPoints.GetRequestUnAuthorized(Routes.GetUsers_Url);
	}

	@Then("User receives {int} Unauthorized Status in response body")
	public void user_receives_unauthorized_status_in_response_body(Integer int1) {
		Tests.GetUnauthorizedValidation(response);
	}

	@Given("Authorized User creates the GET by ID request with valid baseUrl,valid endpoint ,valid id")
	public void authorized_user_creates_the_get_by_id_request_with_valid_base_url_valid_endpoint_valid_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserID_Url);
	}

	@Given("Authorized User creates the GET by ID request with invalid baseUrl,valid endpoint ,valid id")
	public void authorized_user_creates_the_get_by_id_request_with_invalid_base_url_valid_endpoint_valid_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserID_InvalidUrl);
	}

	@Given("Authorized User creates the GET by ID request with valid baseUrl,invalid endpoint ,valid id")
	public void authorized_user_creates_the_get_by_id_request_with_valid_base_url_invalid_endpoint_valid_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserID_InvalidEP);
	}

	@Given("Unauthorized User creates the GET by ID request with valid baseUrl,valid endpoint ,valid id")
	public void unauthorized_user_creates_the_get_by_id_request_with_valid_base_url_valid_endpoint_valid_id() {
		this.request = AssignEndPoints.GetRequestUnAuthorized(Routes.GetUserID_Url);
	}

	@Given("Authorized User creates the GET by FirstName request with valid baseUrl,valid endpoint ,valid firstname")
	public void authorized_user_creates_the_get_by_first_name_request_with_valid_base_url_valid_endpoint_valid_firstname() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserFirstName_Url);
	}

	@Given("Authorized User creates the GET by FirstName request with invalid baseUrl,valid endpoint ,valid firstname")
	public void authorized_user_creates_the_get_by_first_name_request_with_invalid_base_url_valid_endpoint_valid_firstname() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserFirstName_InvalidUrl);
	}

	@Given("Authorized User creates the GET by FirstName request with valid baseUrl,invalid endpoint ,valid firstname")
	public void authorized_user_creates_the_get_by_first_name_request_with_valid_base_url_invalid_endpoint_valid_firstname() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserFirstName_InvalidEP);
	}

	@Given("Unauthorized User creates the GET by FirstName request with valid baseUrl,valid endpoint ,valid firstname")
	public void unauthorized_user_creates_the_get_by_first_name_request_with_valid_base_url_valid_endpoint_valid_firstname() {
		this.request = AssignEndPoints.GetRequestUnAuthorized(Routes.GetUserFirstName_Url);
	}
	
	@Given("Authorized User creates the GET by ID request with valid baseUrl,valid endpoint, invalid id")
	public void authorized_user_creates_the_get_by_id_request_with_valid_base_url_valid_endpoint_invalid_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserID_InvalidID);
	}

	@When("User sends GET request with {string}")
	public void user_sends_get_request_with(String string) {
		this.response = AssignEndPoints.getGetResponseInvalidIDorName(request, string);		
	}
	
	@Then("User receives {int} Bad Request Status in response body")
	public void user_receives_bad_request_status_in_response_body(Integer int1) {
		Tests.GetNegative400Validation(response);
	}
	
	@Given("Authorized User creates the GET by FirstName request with valid baseUrl,valid endpoint ,invalid firstname")
	public void authorized_user_creates_the_get_by_first_name_request_with_valid_base_url_valid_endpoint_invalid_firstname() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.GetUserFirstName_InvalidFN);
	}
	
	@Then("User receives {string} Status in Get response body")
	public void user_receives_status_in_Get_response_body(String string) {
		if ("404".equals(string)) {
			Tests.GetNegative404Validation(response);
		}else if ("400".equals(string)) {
			Tests.GetNegative400Validation(response);
		}else {
			Tests.GetNegative500Validation(response);
		}
	}
	

}
