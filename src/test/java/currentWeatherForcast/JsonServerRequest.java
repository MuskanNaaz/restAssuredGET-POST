package currentWeatherForcast;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import rest_Assured.classes.UserPosts;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class JsonServerRequest {
	@Test
	public void test_1() {
		Response response =  given()
		.when()
		.get("http://localhost:3000/posts");
		System.out.println("Getting response : "+ response.asString());
		
	}
	//@Test
	public void test_2() {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("id", "3");
		payload.put("title", "third Title");
		payload.put("view", "300");
		
		Response response = (Response) given()
				.body(payload)
				.when()
				.contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		//ValidatableResponse getResponse = response.then().statusCode(201);
	}
	//@Test
	public void test_3() {
		
		UserPosts pojo_post = new UserPosts();
		
		pojo_post.setId("4");
		pojo_post.setTitle("This is forth title");
		pojo_post.setViews("tThis is fourth view");
		
		
		Response response = (Response) given()
				.body(pojo_post)
				.contentType(ContentType.JSON)
				.when()
				.post("http://localhost:3000/posts");
		
	}
	@Test
	public void test_4() {
		
		UserPosts pojo_post = new UserPosts();
		
		pojo_post.setId("4");
		pojo_post.setTitle("This is forth+Five title");
		pojo_post.setViews("tThis is fourth view");
		
		
		
		Response response = (Response) given()
				.body(pojo_post)
				.contentType(ContentType.JSON)
				.when()
				.post("http://localhost:3000/posts/4");

		
	}

}
