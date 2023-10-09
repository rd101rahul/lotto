package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Constants;

import static io.restassured.RestAssured.given;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class APIClient {
	private String baseUrl;

	public APIClient(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Response searchForPages(String searchValue) throws UnsupportedEncodingException {
    	
        
        RequestSpecification rq = RestAssured.given().baseUri(baseUrl).queryParam("q", searchValue).log().all();
        System.out.println("Request Specification: " + rq.toString());

        Response response = rq.when().get();
        
    	return response;
        
    }

	public Response getPageDetails() throws UnsupportedEncodingException {
		
		String encodedvalidationTitle = URLEncoder.encode(Constants.validationTitle, "UTF-8").replace("+", "%20");
		Constants.getPageUrl = Constants.getPageUrl.replace("encodedvalidationTitle", encodedvalidationTitle);
        RequestSpecification rq = RestAssured.given().baseUri(Constants.getPageUrl).log().all();
        System.out.println("Request Specification: " + rq.toString());

        Response response = rq.when().get();
    	return response;	}
}
