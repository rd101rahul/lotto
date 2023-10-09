package tests;

import api.APIClient;
import io.restassured.response.Response;
import utils.Constants;

import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetDetailsAPITest {
	private APIClient apiClient;

	@BeforeClass
	public void setup() {
		apiClient = new APIClient(Constants.getPageUrl);
	}

	@Test
	public void getPageDetails() throws UnsupportedEncodingException {

		// WHEN
		Response response = apiClient.getPageDetails();

		// THEN
		Assert.assertEquals(response.getStatusCode(), 200,
				"Expected status code 200 but got " + response.getStatusCode());
		String timestamp = response.jsonPath().get("latest.timestamp");
		System.out.println("Timestamp" + timestamp);

		Assert.assertTrue(timestamp.compareTo("2023-08-17") > 0, "Timestamp is not greater than 2023-08-17");
	}
}
