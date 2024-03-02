package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;

import endPoints.AssignEndPoints;
import endPoints.Routes;
import endPoints.Tests;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteUser_SD {
	
	 RequestSpecification request;
	 Response response;
	 ValidatableResponse valid_response;
	
	@Given("Authorized User sets request with valid Url,valid endpoint by valid user ID")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserID_InvalidID);
	}
	
	@When("User sends DELETE request with valid ID")
	public void user_sends_delete_request_with_valid_id() throws JsonProcessingException {
		this.response = AssignEndPoints.getDeleteResponsevalidID(request);
	}
	
	@When("User sends DELETE request with valid FirstName")
	public void user_sends_delete_request_with_valid_FirstName() throws JsonProcessingException {
		this.response = AssignEndPoints.getDeleteResponsevalidName(request);
	}

	@When("User sends DELETE request")
	public void user_sends_delete_request() {
		this.response = AssignEndPoints.getDeleteResponse(request);
	}

	@Then("User receives {int} OK  Status in response body")
	public void user_receives_ok_status_in_response_body(Integer int1) {
		Tests.GetPositiveValidation(response);
	}

	@Given("Authorized User sets request with invalid Url, valid endpoint by valid user ID")
	public void authorized_user_sets_request_with_invalid_url_valid_endpoint_by_valid_user_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserID_InvalidUrl);
	}

	@Then("User receives {int} Not found  Status in response body")
	public void user_receives_not_found_status_in_response_body(Integer int1) {
		Tests.GetNegative404Validation(response);
	}

	@Given("Authorized User sets request with valid Url, invalid endpoint by valid user ID")
	public void authorized_user_sets_request_with_valid_url_invalid_endpoint_by_valid_user_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserID_InvalidEP);
	}

	@Given("Unauthorized User sets request with valid Url,valid endpoint by valid user ID")
	public void unauthorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_id() {
		this.request = AssignEndPoints.GetRequestUnAuthorized(Routes.DeleteUserID_Url);
	}

	@Then("User receives {int} Unauthorized  Status in response body")
	public void user_receives_unauthorized_status_in_response_body(Integer int1) {
		Tests.GetUnauthorizedValidation(response);
	}

	@Given("Authorized User sets request with valid Url,valid endpoint and valid user first name")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_and_valid_user_first_name() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserID_InvalidID);
	}

	@Given("Authorized User sets request with invalid Url,valid endpoint by valid user first name")
	public void authorized_user_sets_request_with_invalid_url_valid_endpoint_by_valid_user_first_name() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserFirstName_InvalidUrl);
	}

	@Given("Authorized User sets request with valid Url, invalid endpoint by valid user first name")
	public void authorized_user_sets_request_with_valid_url_invalid_endpoint_by_valid_user_first_name() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserFirstName_InvalidEP);
	}

	@Given("Unauthorized User sets request with valid Url,valid endpoint by valid user first name")
	public void unauthorized_user_sets_request_with_valid_url_valid_endpoint_by_valid_user_first_name() {
		this.request = AssignEndPoints.GetRequestUnAuthorized(Routes.DeleteUserFirstName_Url);
	}
	
	@Given("Authorized User sets request with valid Url,valid endpoint by invalid user ID")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_by_invalid_user_id() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserID_InvalidID);
	}

	@When("User sends DELETE request with valid Url,valid endpoint, with {string}")
	public void user_sends_delete_request_with_valid_url_valid_endpoint_with(String string) {
		this.response = AssignEndPoints.getDeleteResponseInvalidIDorName(request, string);
	}

	@Then("User receives {string} Status in response body")
	public void user_receives_status_in_response_body(String string) {
		if ("404".equals(string)) {
			Tests.GetNegative404Validation(response);
		}else if ("400".equals(string)) {
			Tests.GetNegative400Validation(response);
		}else {
			Tests.GetNegative500Validation(response);
		}
	}

	@Given("Authorized User sets request with valid Url,valid endpoint by invalid user first name")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_by_invalid_user_first_name() {
		this.request = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserFirstName_InvalidFN);
	}

}
