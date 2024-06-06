package com.spotify.api;

import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders 
{
	
	ResponseSpecification responsespecification;
	String PlaylistID;
	
	public static RequestSpecification reqSpec()
	{
			return new RequestSpecBuilder()
			.setBaseUri("https://api.spotify.com")
			.setBasePath("v1")
//			.addHeader("Authorization", "Bearer BQBStA0O5XEeu-JZ84KItVoQ5CwABGeUoXSgXdaTbtRjSfJL5GnEDD4z9gzVCtGCb3xLbMm5ANS2qXHmyA_xmP8sewbiar-9w_ZqqYmGd0Z1qHgjeQXGdk0ftLUU45-43QgkFqr5c5ea5eoEB9NPC3ckeZDhkV7Ep8GANmVwHqhXhwjQ34eHGnI_390p2uGDguctWYNrUp_oCAsxyzKBjwlEbWE-EjzsOpjstxDJB2j0Ky7gMf_Sj6bcNGJhliL-mwEnTchhjyCPQNFw")
			.setAccept(ContentType.JSON)
			.log(LogDetail.ALL)
			 .build();
   }
	
	public static ResponseSpecification resSpec()
	{
					return new ResponseSpecBuilder()
//					.expectContentType(ContentType.JSON)
					.log(LogDetail.ALL)
					.build();
	}
}
