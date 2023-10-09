package tests;

import api.APIClient;
import io.restassured.response.Response;
import utils.Constants;

import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchAPITest {
    private APIClient apiClient;

    @BeforeClass
    public void setup() {
        apiClient = new APIClient(Constants.serachContentUrl);
    }

    @Test
    public void testSearchForFurryRabbits() throws UnsupportedEncodingException {
        // GIVEN, we have search COntent Value

        // WHEN
        Response response = apiClient.searchForPages(Constants.searchContent);

        // THEN
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 but got " + response.getStatusCode());
        String responseBody = response.getBody().asString();

        Assert.assertTrue(responseBody.contains(Constants.validationTitle), "Sesame Street page not found in search results");
    }
}
