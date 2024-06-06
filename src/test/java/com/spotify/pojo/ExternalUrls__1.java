package com.spotify.pojo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)  
// It will include those values which are not null
// If we required there should be at least some value. Use NON_EMPTY
// @JsonInclude(JsonInclude.Include.NON_EMPTY)
// @JsonIgnore - To  ignore specific properties of JSON to during serialization 
// @JsonProperty - annotation is useful when the name of the Java property differs 
// from the desired JSON property name.

@JsonPropertyOrder({
    "spotify"
})

public class ExternalUrls__1 {
	
	// Variable define : camal case 

    @JsonProperty("spotify")
    private String spotify;

    @JsonProperty("spotify")
    public String getSpotify() {
        return spotify;
    }

    @JsonProperty("spotify")
    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

}
