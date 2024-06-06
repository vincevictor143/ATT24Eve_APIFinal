package com.spotify.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.api.PlayList;
import com.spotify.api.SpecBuilders;
import com.spotify.pojo.Playlist;

import authmanager.TokenCreator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import utils.ConfigReader;
@Epic("Spotify Auth 2.0")
@Feature("Playlist API")
public class CreateAndGetPlaylistAPI_ReusuableMethods 
{
	static String PlaylistID;
	
	@Story("Create Playlist")
	@Description("Creating a playlistfor Tejab Songs")
	 @Test(priority=1)
	 public void createPlayListMethod() throws IOException
	 {
		     Playlist reqplaylist=new Playlist();
		     reqplaylist.setName(ConfigReader.readConfig());
		     reqplaylist.setDescription("Old Memories1");
		     reqplaylist.setPublic(false);
		     
		     Response response = PlayList.post(reqplaylist,TokenCreator.renewToken());
		    		 
		     Playlist responsePlaylist = response.as(Playlist.class);
		 	  	
		     String nameValue=responsePlaylist.getName();
		     String nameresponse = reqplaylist.getName();
		     PlaylistID = responsePlaylist.getId();
		     Assert.assertEquals(nameValue, nameresponse);  
	 }
	 
	@Story("Create Playlist")
	@Description("Creating a playlistfor Tejab Songs")
	 @Test(priority=2)
	 public void getPlayListMethod() throws IOException
	 {
		 
		 Playlist reqplaylist=new Playlist();
		 reqplaylist.setName(ConfigReader.readConfig());
		 reqplaylist.setDescription("Old Memories");
		 reqplaylist.setPublic(false);
		 
		 Response response=PlayList.get(PlaylistID,TokenCreator.renewToken());
		 Playlist responseplaylist = response.as(Playlist.class);	
		 Assert.assertEquals(responseplaylist.getName(), reqplaylist.getName());
		 
	 }
	 
	@Story("Create Playlist")
	@Description("Creating a playlistfor Tejab Songs")
	 @Test(priority=3)
	 public void updatePlayList() throws IOException
	 {
		 
		 Playlist reqplaylist=new Playlist();
		 reqplaylist.setName(ConfigReader.readConfig());
		 reqplaylist.setDescription("Old Memories");
		 reqplaylist.setPublic(false);
		 
		 Response response=PlayList.update(PlaylistID,reqplaylist,TokenCreator.renewToken());
		 
		 int statusCode = response.getStatusCode();
		 
		 Assert.assertEquals(statusCode, 200);
	 }
	 
	@Story("Create Playlist")
	@Description("Creating a playlistfor Tejab Songs")
	 @Test(priority=4)
	 public void shouldNotCreatePlaylist() throws IOException
	 {
		 
		 Playlist reqplaylist=new Playlist();
		 reqplaylist.setName(ConfigReader.readConfig());
		 reqplaylist.setDescription("Old Memories");
		 reqplaylist.setPublic(false);
		 
		 Response response=PlayList.post(reqplaylist,"123445");
		 
		 int statusCode = response.getStatusCode();
		 
		 Assert.assertEquals(statusCode, 401);
		 
	 }
	 
	 
		 
		 
	 
	
}
