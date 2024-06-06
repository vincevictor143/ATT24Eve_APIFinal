package com.spotify.api;

import static io.restassured.RestAssured.given;

import com.spotify.pojo.Playlist;
import io.restassured.response.Response;

public class PlayList 
{
		// reusuable methods 
	
	   public static Response post(Playlist requestPlaylist,String token)
	   {
		    return given(SpecBuilders.reqSpec())
		    .auth().oauth2(token)
	 	  	.body(requestPlaylist)
	 	  	.when()
	 	  	.post("/users/313mlih4sbdx5c33nil3sc3m3pea/playlists")
	 	  	.then()
	 	  	.spec(SpecBuilders.resSpec())
	 	  	.extract()
	 	  	.response();
	   }
	   
	   public static Response get(String PlaylistID,String token )
	   {
		   return given(SpecBuilders.reqSpec())
		    .auth().oauth2(token)
			.when()
			.get("/playlists/"+PlaylistID)
			.then()
			.spec(SpecBuilders.resSpec())
			.extract()
			.response();
	   }
	   
	   public static Response update(String PlaylistID,Playlist requestPlaylist,String token )
	   {
		   return given(SpecBuilders.reqSpec())
			.auth().oauth2(token)
			 .body(requestPlaylist)
			.when()
			.put("/playlists/"+PlaylistID)
			.then()
			.spec(SpecBuilders.resSpec())
			.extract()
			.response();
	   }

}
