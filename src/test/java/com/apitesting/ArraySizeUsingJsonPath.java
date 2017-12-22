package com.apitesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ArraySizeUsingJsonPath {
	
	
	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://maps.googleapis.com";
	  }
	  
	  @Test
	  public void arraySize()  {
	  int size= given ().param ("query", "Churchgate Station")
	    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
	    .when()
	    .get ("/maps/api/place/textsearch/json")
	    .then()
	    .extract()
	    .path("results[0].geometry.location.size()");
	  
	  System.out.println("The size is "+size);
	  }

}
