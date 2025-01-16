package com.colab.apitests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class Login {
@Test
	private void styles()
	{
		RestAssured.baseURI= "https://radiumapi.nexaei.com/api/User/login";
		 String requestBody = "{ \"email\": \"dharmender02@mailinator.com\", \"password\": \"4TTsVQRqJuBWfzJ9Mrrg4g==\" }";
		 
		
		Response resp= (Response) RestAssured.given().header("Content-Type", "application/json").body(requestBody)
		.when().then().expect().response();
		resp.prettyPrint();
		 String responseString = resp.asString();
		 JSONObject jsonResponse = new JSONObject(responseString);
		 JSONObject tokenr = jsonResponse.getJSONObject("data");
		 String token = resp.jsonPath().getString("data['id']");
		// String token = resp.jsonPath().getString("data.fname");
		 
	        System.out.println("Token received: " + tokenr);
		
	}
}
