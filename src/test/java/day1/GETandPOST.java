package day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GETandPOST {
	
	@BeforeMethod
	public void setup() {
		 RestAssured.baseURI= "https://reqres.in/api/";
	}
	@Test(priority = 1)
	public void test_1(){
		ValidatableResponse response =  given()
				.get("users?page=2")
				.then()
				.statusCode(200)
				.body("data[3].first_name", equalTo("Byron"))
				.body("data.last_name", hasItem("Howell"));
	}
	
	@Test (priority = 2)
	public void test_2Post() {
		Map<String, Object> payLoad = new HashMap<String, Object>();
		
		payLoad.put("name", "morpheus");
		payLoad.put("job", "leader");
		System.out.println(payLoad );
		
	}

}
