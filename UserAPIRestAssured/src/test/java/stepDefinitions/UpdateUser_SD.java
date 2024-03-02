package stepDefinitions;

import endPoints.AssignEndPoints;
import endPoints.Routes;
import endPoints.Tests;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateUser_SD {
	 RequestSpecification request;
	 Response response;
	 ValidatableResponse valid_response;
	
	@Given("User sets PUT request for with valid Url, invalid endpoint and valid request body")
	public void user_sets_put_request_for_with_valid_url_invalid_endpoint_and_valid_request_body() {
		this.request = AssignEndPoints.getPostRequestAuthorized(Routes.PutUserId_InvalidEP);
	}

	@When("User sends PUT request")
	public void user_sends_put_request() {
		this.response = AssignEndPoints.getPutResponse(request);
	}

	@Then("User receives {int} status in response body")
	public void user_receives_status_in_response_body(Integer int1) {
		Tests.GetNegative404Validation(response);
	}

	@Given("User sets PUT request for with invalid Url, valid endpoint and valid request body")
	public void user_sets_put_request_for_with_invalid_url_valid_endpoint_and_valid_request_body() {
		this.request = AssignEndPoints.getPostRequestAuthorized(Routes.PutUserId_InvalidUrl);
	}
	
	@Given("Authorized User sets PUT request with valid Url,valid endpoint, request body with {string} and {string} from excel")
	public void authorized_user_sets_put_request_with_valid_url_valid_endpoint_request_body_with_and_from_excel(String string1, String string2) throws Exception {
		this.request = AssignEndPoints.getPostRequestDataDrivenAuthorized(string1,string2,Routes.PutUser_Url);
	}

	@Then("User receives {string} in the response body.")
	public void user_receives_in_the_response_body(String string) {
		if("200".equals(string)) {
			Tests.Put200PositiveValidation(response);
		}else if ("400".equals(string)) {
			Tests.GetNegative400Validation(response);
		}else {
			Tests.GetNegative500Validation(response);
		}
	}
	
	@Given("Authorized User sets PUT request with valid Url,valid endpoint,request body with invalid user ID, {string} and {string} from excel")
	public void authorized_user_sets_put_request_with_valid_url_valid_endpoint_request_body_with_invalid_user_id_and_from_excel(String string1, String string2) throws Exception {
		this.request = AssignEndPoints.getPostRequestDataDrivenAuthorized(string1,string2,Routes.PutUserId_InvalidID);   
	}

	@When("User sends PUT request with {string}")
	public void user_sends_put_request_with(String string) {
		this.response = AssignEndPoints.getPutResponseInvalidID(request, string);
	}
}
