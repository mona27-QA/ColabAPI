package com.colab.apitests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class Login {
@Test
	private void styles()
	{
		RestAssured.baseURI= "https://radiumapi.nexaei.com/api/";
		 String requestBody = "{ \"email\": \"dharmender02@mailinator.com\", \"pwd\": \"4TTsVQRqJuBWfzJ9Mrrg4g==\" }";
		 
		
		Response resp= RestAssured.given().header("Content-Type", "application/json").body(requestBody)
		.when().post("User/login").then().extract().response();
		
//		 String responseString = resp.asString();
//		 JSONObject jsonResponse = new JSONObject(responseString);
//		 JSONObject tokenr = jsonResponse.getJSONObject("data");
//		 String token = resp.jsonPath().getString("data['id']");
	String token = resp.jsonPath().getString("data.token");
		 
	        System.out.println("Token received: " + token);
		
	}
}
