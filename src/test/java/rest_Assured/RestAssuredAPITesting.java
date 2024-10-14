package rest_Assured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class RestAssuredAPITesting {
	
	@BeforeClass
	
	public void setup() {
		RestAssured.baseURI = "https://www.nightsbridge.com";
	}
	
	//GET request and validate response
	@Test(priority = 1)
	public void getResquest() {
		io.restassured.response.Response response = given().
			when().
			get("/bridge/api/5.0/establishment/30628").
			then().
			extract().
			response();
	
	System.out.println("Response Body: "+response.asString());
	int statusCode = response.getStatusCode();
	System.out.println("Response Status Code : : "+statusCode);
	System.out.println("Content-Type :" + response.getContentType());
	
	assert statusCode == 200 : "Correct status code returned"+ statusCode;
			
	System.out.println(response.getStatusCode());
	System.out.println(response.getTime());
	}
	
	@Test(priority = 2)
	public void testJSONSpecificResponseData() {
		Response response  = given().
				contentType(ContentType.JSON).
				when().
				get("/bridge/api/5.0/establishment/30628");
		
		Assert.assertEquals(response.header("Content-Type"), "application/json");
		
		String childPolicy = response.jsonPath().get("data.contentrs.childpolicy.childage1").toString();
		System.out.println("Provide the child policy" + childPolicy);
	}
	//@Test(priority = 3)
	public void creatPostRequest() {
		HashMap payLoad = new HashMap<>();
		payLoad.put("bbid", 30628);
		
		payLoad.put("startdate", "2024-10-09");
		payLoad.put("enddate", "2024-10-10");
		payLoad.put("nightsbridge", true);
		payLoad.put("bbrtid", 0);
		payLoad.put("promocode", "");
		
		
		Response response = (Response) given().contentType(ContentType.JSON).body(payLoad).when().post("/bridge/api/5.0/availability/30628")
				.then()
				.assertThat()
				.statusCode(201)
				.extract()
				.response();
		
		System.out.println("Response Body : "+ response.getBody().asString());
		
		
		
	}
	@Test(priority = 3)
	public void updateRequest() {
		HashMap payLoad = new HashMap<>();
		payLoad.put("bbid", 30628);
		
		payLoad.put("startdate", "2024-12-09");
		payLoad.put("enddate", "2024-10-18");
		
		
		Response response = (Response) given().contentType(ContentType.JSON).body(payLoad).when().post("/bridge/api/5.0/availability/30628")
				.then()
				.assertThat()
				.statusCode(201)
				.extract()
				.response();
		
		System.out.println("Response Body : "+ response.getBody().asString());
		
		
		
	}
	
	

}
