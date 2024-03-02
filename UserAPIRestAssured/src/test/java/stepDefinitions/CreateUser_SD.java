package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojos.userAddressPojo;
import Pojos.userPojo;
import endPoints.AssignEndPoints;
import endPoints.Routes;
import endPoints.Tests;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateUser_SD {
	
	 RequestSpecification request;
	 Response response;
	 ValidatableResponse valid_response;
	
	@Given("Authorized User sets request with valid Url,valid endpoint and valid request body")
	public void authorized_user_sets_request_with_valid_url_valid_endpoint_and_valid_request_body() {
		this.request = AssignEndPoints.getPostRequestAuthorized(Routes.PostUser_Url);
	}

	@When("User sends POST request")
	public void user_sends_post_request() {
		this.response = AssignEndPoints.getPostResponse(request);
	}

	@Then("User receives {int} OK Status and valid response in response body")
	public void user_receives_ok_status_and_valid_response_in_response_body(Integer int1) {
		Tests.Post201PositiveValidation(response);
	}
	
	@Given("Authorized User sets Post request with valid Url,valid endpoint, request body with {string} and {string} from excel")
	public void authorized_user_sets_post_request_with_valid_url_valid_endpoint_request_body_with_and_from_excel(String string1, String string2) throws Exception {
		this.request = AssignEndPoints.getPostRequestDataDrivenAuthorized(string1,string2,Routes.PostUser_Url);
	}

	@Then("User receives {string} in response body.")
	public void user_receives_in_response_body(String string) {
		if("201".equals(string)) {
			Tests.Post201PositiveValidation(response);
		}else if ("400".equals(string)) {
			Tests.GetNegative400Validation(response);
		}else if ("409".equals(string)) {
			Tests.GetNegative409Validation(response);
		}
	}
	
	@Given("User sets request for with valid Url, invalid endpoint and valid request body")
	public void user_sets_request_for_with_valid_url_invalid_endpoint_and_valid_request_body() {
		this.request = AssignEndPoints.getPostRequestAuthorized(Routes.PostUser_InvalidEP);
	}

	@Then("User receives {int} Not found status in response body")
	public void user_receives_not_found_status_in_response_body(Integer int1) {
		Tests.GetNegative404Validation(response);
	}

	@Given("User sets request for with invalid Url, valid endpoint and valid request body")
	public void user_sets_request_for_with_invalid_url_valid_endpoint_and_valid_request_body() {
		this.request = AssignEndPoints.getPostRequestAuthorized(Routes.PostUser_InvalidUrl);
	}

}
