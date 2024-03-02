package endPoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelReader;
import utilities.FileNameConstants;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Config.PropertiesFile;
import Pojos.userAddressPojo;
import Pojos.userPojo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class AssignEndPoints extends ExcelReader {
	
	static RequestSpecification request;
	static Response response;
	static ValidatableResponse valid_response;

	static String Username = PropertiesFile.readPropertiesFile("username");
	static String Password = PropertiesFile.readPropertiesFile("password");
	
	public static RequestSpecification GetRequestAuthorized(String url) {
		request = 
		RestAssured
			.given()
//				.log().all()
				.auth().basic(Username,Password)
				.contentType(ContentType.JSON)
				.baseUri(url);	
		return request;
	}
	
	public static RequestSpecification GetRequestUnAuthorized(String url) {
		request = 
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.baseUri(url);	
		return request;
	}
	
	public static RequestSpecification getPostRequestAuthorized(String url) {
		
		try {
			userAddressPojo uAP = new userAddressPojo("T5-5TM","apiUser","WA","USA","56789");
			userPojo uP = new userPojo("JyothsnaFive","ApiBootcamp","1230056688","teamfive.botcamp@uapi.com",uAP);
				
			// Using the object Mapper, we can serialize or de-serialize objects from one type to another .
			ObjectMapper objectMapper = new ObjectMapper(); 
				
			//Serialization- Convert the java class object(up) into the json object(requestBody)
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uP);		
			//De-serialization- Convert the json object(requestBody) into the java class object(up).
//			userPojo userDetails = objectMapper.readValue(requestBody, userPojo.class);
			request =  
				RestAssured
					.given()
						.auth().basic(Username,Password)
						.contentType(ContentType.JSON)
						.body(requestBody)
						.baseUri(url);	
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}	
	
	public static Response getPostResponse(RequestSpecification request) {
		response = request.when().post();				
		return response;
	}
	
	public static Response getPutResponse(RequestSpecification request) {
		response = request.when().put();				
		return response;
	}
	
	public static Response getGetResponse(RequestSpecification request) {
		response = request.when().get();					
		return response;
	}
	
	public static Response getDeleteResponse(RequestSpecification request) {
		response = request.when().delete();					
		return response;
	}
	
	public static Response getGetResponseInvalidIDorName(RequestSpecification request, String UserIdorName ) {
		response = request.when().get("/{UserIdorName}",UserIdorName);					
		return response;
	}
	
	public static Response getPutResponseInvalidID(RequestSpecification request, String UserId ) {
		response = request.when().put("/{UserId}",UserId);					
		return response;
	}
	
	public static Response getDeleteResponsevalidID(RequestSpecification request) throws JsonProcessingException {
			Response res;
			
			userAddressPojo uAP = new userAddressPojo("T5-5TM","apiUser","WA","USA","56789");
			userPojo uP = new userPojo("JyothsnaFive","ApiBootcamp","1230056688","teamfive.botcamp@uapi.com",uAP);
		
			ObjectMapper objectMapper = new ObjectMapper(); 
			
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uP);		
			
			res = RestAssured
				.given()
					.auth().basic(Username,Password)
					.contentType(ContentType.JSON)
					.body(requestBody)
					.baseUri(Routes.PostUser_Url)
				.when()
					.post()
				.then()
					.assertThat()
					.statusCode(201)
				.extract()
					.response();
			
			int ID = res.path("user_id");
			String userID = Integer.toString(ID);
		
		response = request.when().delete("/{UserId}",userID);					
		return response;
	}
	
	public static Response getDeleteResponsevalidName(RequestSpecification request) throws JsonProcessingException {
		Response res;
		
		userAddressPojo uAP = new userAddressPojo("T5-5TM","apiUser","WA","USA","56789");
		userPojo uP = new userPojo("JyothsnaFive","ApiBootcamp","1230056688","teamfive.botcamp@uapi.com",uAP);
	
		ObjectMapper objectMapper = new ObjectMapper(); 
		
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uP);		
		
		res = RestAssured
			.given()
				.auth().basic(Username,Password)
				.contentType(ContentType.JSON)
				.body(requestBody)
				.baseUri(Routes.PostUser_Url)
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(201)
			.extract()
				.response();
		
		String firstName = res.path("user_first_name");

		response = request.when().delete("/{UserName}",firstName);					
		return response;
	}
	
	public static Response getDeleteResponseInvalidIDorName(RequestSpecification request, String UserIDotName) {
		response = request.when().delete("/{UserIDotName}",UserIDotName);					
		return response;
	}
	
//	public static String createandGetUserIDForDelete(){
//		
//		try {
//			userAddressPojo uAP = new userAddressPojo("T5-5TM","apiUser","WA","USA","56789");
//			userPojo uP = new userPojo("JyothsnaFive","ApiBootcamp","1230056688","teamfive.botcamp@uapi.com",uAP);
//		
//			ObjectMapper objectMapper = new ObjectMapper(); 
//			
//			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uP);		
//			
//			RestAssured
//				.given()
//					.auth().basic(Username,Password)
//					.contentType(ContentType.JSON)
//					.body(requestBody)
//					.baseUri(Routes.PostUser_Url)
//				.when()
//					.post()
//				.then()
//					.assertThat()
//					.statusCode(201)
//				.extract()
//					.response();
//			
//			int ID = response.path("user_id");
//			String userID = Integer.toString(ID);
//			
//			return userID;
//	
//		} catch (JsonProcessingException e) {
//			
//			e.printStackTrace();
//			return "NoUserID";
//		}
//	}
	
//	public static String createandGetUserFirstNameForDelete(){
//		
//		try {
//			userAddressPojo uAP = new userAddressPojo("T5-5TM","apiUser","WA","USA","56789");
//			userPojo uP = new userPojo("JyothsnaFive","ApiBootcamp","1230056688","teamfive.botcamp@uapi.com",uAP);
//		
//			ObjectMapper objectMapper = new ObjectMapper(); 
//			
//			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uP);		
//			
//			RestAssured
//				.given()
//					.auth().basic(Username,Password)
//					.contentType(ContentType.JSON)
//					.body(requestBody)
//					.baseUri(Routes.PostUser_Url)
//				.when()
//					.post()
//				.then()
//					.assertThat()
//					.statusCode(201)
//				.extract()
//					.response();
//			
//			String firstName = response.path("user_first_name");
//			
//			return firstName;
//	
//		} catch (JsonProcessingException e) {
//			
//			e.printStackTrace();
//			return "NoFirstName";
//		}
//	
//	}
	
	public static RequestSpecification getPostRequestDataDrivenAuthorized(String TestCaseNumber, String sheetName, String url) throws Exception {
		
		try {

			Map<String, String> excelDataMap;
			excelDataMap = ExcelReader.getData(TestCaseNumber, sheetName);
			
			String fn = excelDataMap.get("user_first_name");
			String ln = excelDataMap.get("user_last_name");
			String contact = excelDataMap.get("user_contact_number");
			String email = excelDataMap.get("user_email_id");
			
			String plot = excelDataMap.get("plotNumber");
			String street = excelDataMap.get("Street");
			String state = excelDataMap.get("state");
			String Country = excelDataMap.get("Country");
			String zip = excelDataMap.get("zipCode");
			
			userAddressPojo uAP = new userAddressPojo(plot,street,state,Country,zip);
			userPojo uP = new userPojo(fn,ln,contact,email,uAP);
			
			ObjectMapper objectMapper = new ObjectMapper(); 
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uP);	
			
			request =  
				RestAssured
					.given()
//						.log().all()
						.auth().basic(Username,Password)
						.contentType(ContentType.JSON)
						.body(requestBody)
						.baseUri(url);	
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return request;
	}
	public static void updateUser() {


	}



}
