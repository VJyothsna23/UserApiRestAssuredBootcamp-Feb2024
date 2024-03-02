package endPoints;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.FileNameConstants;

public class Tests {
	
	public static void GetPositiveValidation(Response response) {

			response
				.then()
					.assertThat()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 ")
					.header("Content-Type", "application/json");
						
	}
	
	public static void Post201PositiveValidation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.JSON_SCHEMA), "UTF-8");		
		
			response
				.then()
//				.log().all()
				.assertThat()
				.statusCode(201)
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
//		.extract()
//			.response();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	int userID = response.path("user_id");
	String ID = Integer.toString(userID);
	
	//validate post by using Get request by ID.
	RequestSpecification getrequest = AssignEndPoints.GetRequestAuthorized(Routes.GetUserID_InvalidID);
	Response getresponse = AssignEndPoints.getGetResponseInvalidIDorName(getrequest,ID);
	GetPositiveValidation(getresponse);
	
	//Delete the careted user after validation for data cleanup.
	RequestSpecification deleterequest = AssignEndPoints.GetRequestAuthorized(Routes.DeleteUserID_InvalidID);
	Response deleteresponse = AssignEndPoints.getDeleteResponseInvalidIDorName(deleterequest,ID);
	GetPositiveValidation(deleteresponse);
	
	}
	
	public static void Put200PositiveValidation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.JSON_SCHEMA), "UTF-8");				
			
			response
				.then()
//				.log().all()
				.assertThat()
				.statusCode(200)
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GetUnauthorizedValidation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(401)
				.statusLine("HTTP/1.1 401 ")
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative404Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(404)
				.statusLine("HTTP/1.1 404 ")
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative400Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(400)
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative409Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(409)
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative500Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(500)
				.header("Content-Type", "application/json");
	}

}
