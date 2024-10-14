package currentWeatherForcast;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class WeatherGetRequest {

	// @Test
	public void test_1() {

		Response response = given()

				.get("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=83a1f9a2694ddfe79e2639643c8490df");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	// @Test
	public void test_2() {

		Response response = given()

				.get("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=83a1f9a2694ddfe79e639643c8490df");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 401);
	}

	// How to use Parameter with rest assured
	//@Test
	public void test_3() {

		Response response = given().param("lat", "44.34")
				.param("lon", "10.99")
				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()
				.get("https://api.openweathermap.org/data/2.5/weather");

		if (response.getStatusCode() == 200) {
			System.out.println("API is working fine");
		} else {
			System.out.println("OOPS!!! its not workinh fine");
		}
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void test_4() {
		Response response = (Response) given()
				// .param("lat", "44.34")
				// .param("lon", "10.99")
				.param("q", "London")
				.param("limit", "5")

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()
				// .get("https://api.openweathermap.org/data/2.5/weather")
				.get("http://api.openweathermap.org/geo/1.0/direct");
		
		response.then().assertThat().statusCode(200);
		
	}
	@Test
	public void test_5() {
		Response response = (Response) given()
				// .param("lat", "44.34")
				// .param("lon", "10.99")
				.param("q", "Johannesburg")
				.param("limit", "5")

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()
				// .get("https://api.openweathermap.org/data/2.5/weather")
				.get("http://api.openweathermap.org/geo/1.0/direct");
		
		System.out.println(response.asString());
		
	}
	
	@Test
	public void test_6() {
		Response response = (Response) given()
				// .param("lat", "44.34")
				// .param("lon", "10.99")
				.param("q", "Johannesburg")
				.param("limit", "5")

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()
				// .get("https://api.openweathermap.org/data/2.5/weather")
				.get("http://api.openweathermap.org/geo/1.0/direct");
		
		System.out.println(response.asString());
		
	}

}
