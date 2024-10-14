package day1;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class FirstRestTest {
	Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	@Test(priority = 1)
	public void test_1() {
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().toString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("Content-type"));
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	@Test(priority = 2)
	public void test_2() {
		baseURI =("https://reqres.in/api/");
		
		given().
		get("users?page=2")
		.then()
		.statusCode(200)
		.body("data[1].email", equalTo("lindsay.ferguson@reqres.in"));
	}
	

}
