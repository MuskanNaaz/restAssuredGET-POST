package currentWeatherForcast;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class WeatherPathFinder {
	 //@Test
	public void test_1() {
		String weatherReport = given().param("lat", "-26.205").param("lon", "28.049722")

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()

				.get("https://api.openweathermap.org/data/2.5/weather").then().contentType(ContentType.JSON).extract()
				.path("weather[0].description");

		System.out.println("Weather Report: " + weatherReport);

	}

	// @Test
	public void test_2() {
		Response weatherReport = given().param("lat", "-26.205").param("lon", "28.049722")

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()

				.get("https://api.openweathermap.org/data/2.5/weather");

		String actualWeatherReport = weatherReport

				.then().contentType(ContentType.JSON).extract().path("weather[0].description");

		String expectedWeatherReport = "overcast clouds";

		if (actualWeatherReport.equalsIgnoreCase(expectedWeatherReport)) {
			System.out.println("Test Case pass:");

		} else {
			System.out.println("TestCase fail");
		}

	}

	@Test
	public void test_3() {
		Response weatherReportThroughidandName = given().param("id", "993800").param("name", "Johannesburg")

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()

				.get("https://api.openweathermap.org/data/2.5/weather");

		String reportbyIDandName = weatherReportThroughidandName

				.then().contentType(ContentType.JSON).extract().path("weather[0].description");

		String expectedWeatherReport = "overcast clouds";

		if (reportbyIDandName.equalsIgnoreCase(expectedWeatherReport)) {
			System.out.println("Weather description by id and Name + Test Case pass:");

		} else {
			System.out.println("TestCase fail");
		}
		Float longi = weatherReportThroughidandName.then().contentType(ContentType.JSON).extract().path("coord.lon");

		System.out.println("Longitude is : " + longi);

		Float lat = weatherReportThroughidandName.then().contentType(ContentType.JSON).extract().path("coord.lat");
		System.out.println("Longitude is : " + lat);
		
		

	}
	@Test
	public void test_4() {
		Response weatherReportThroughidandName = given().param("id", "993800").param("name", "Johannesburg")

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()

				.get("https://api.openweathermap.org/data/2.5/weather");

		String reportbyIDandName = weatherReportThroughidandName

				.then().contentType(ContentType.JSON).extract().path("weather[0].description");

		System.out.println("Weather description by ID and NAME: " + reportbyIDandName);


		Float longi = weatherReportThroughidandName.then().contentType(ContentType.JSON).extract().path("coord.lon");

		System.out.println("Longitude is : " + longi);

		Float lat = weatherReportThroughidandName.then().contentType(ContentType.JSON).extract().path("coord.lat");
		System.out.println("Longitude is : " + lat);

		Response responsebyCoord = given().param("lat", lat).param("lon", longi)

				.param("appid", "83a1f9a2694ddfe79e2639643c8490df").when()

				.get("https://api.openweathermap.org/data/2.5/weather");
		String reportbyCoord = responsebyCoord
		.then()
		.contentType(ContentType.JSON)
		.extract()
		.path("weather[0].description");
		
		System.out.println("Extratced the weather from lat & long: " + reportbyCoord);
		
		Assert.assertEquals(reportbyIDandName, reportbyCoord);
	}
}
