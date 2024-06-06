package authmanager;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenCreator 
{
	
	 public static String renewToken()
	 {
		 HashMap<String,String> param=new HashMap<String,String>();
		 param.put("grant_type", "refresh_token");
		 param.put("refresh_token", "AQCSZ4rhwRbzcnj3HcQ1v6HEx2Or2N7o9BktY9iB1YYgWgc9l8u8iaKhjum67yRd3M3qlyE6v8z_vy38M6ABjoF1PopeYoZfdgcHD_8Pt0GcqamTVdQba9aY8VCI0frfBQ0");
		 param.put("client_id", "3a91a80563cb4b07922af0b0da5207ec");
		 param.put("client_secret", "9c95bc1e072e41f881f452055a094008");
		 
		 
		      RestAssured.baseURI="https://accounts.spotify.com";
		      
		         Response response = given()
		         .contentType(ContentType.URLENC)
		         .formParams(param)
		         .when()
		         .post("/api/token")
		         .then()
		         .extract()
		         .response();
		         
		         if(response.getStatusCode()!=200)
		         {
		        	  throw new RuntimeException("Failed to generate the Access Token");
		         }
		         
		         // Another way of accessing value of simple json key
		         
		         String token = response.path("access_token");
		         return token;
	 }

}
