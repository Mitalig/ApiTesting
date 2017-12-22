package com.apitesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static  io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


public class AssertionTest {
	
	
	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://maps.googleapis.com";
	  }
	  
	  //@Test
	  public void singleAssertion()  {
	   given ().param ("query", "Churchgate Station")
	    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
	    .when()
	    .get ("/maps/api/place/textsearch/json")
	    .then()
	    .contentType(ContentType.JSON)
	    .body("results[0].formatted_address",
	    		equalTo("Maharshi Karve Road, Churchgate, Mumbai, Maharashtra 400020, India"));

	  }
	  
	 // @Test
	  public void hasItemInArrayList ()  {
		  given ().param ("query", "Churchgate Station")
		    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
		    .when()
		    .get ("/maps/api/place/textsearch/json")
		    .then()
		    .contentType(ContentType.JSON)
		    .body("results[0].types",
		    		hasItem("transit_station"));

		  }
		  
	  //@Test
	  public void hasItemsAssert()  {
		  given ().param ("query", "Churchgate Station")
		    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
		    .when()
		    .get ("/maps/api/place/textsearch/json")
		    .then()
		    .contentType(ContentType.JSON)
		    .body("results[0].types",
		    		hasItems("transit_station","train_station"));
	
	  }
	  
	 // @Test
	  public void hasKeyAssert()  {
		  given ().param ("query", "Churchgate Station")
		    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
		    .when()
		    .get ("/maps/api/place/textsearch/json")
		    .then()
		    .contentType(ContentType.JSON)
		    .body("results[0].geometry.location",
		    		hasKey("lat"));
	
	  }
	  
	  //@Test
	  public void multipleAssertions ()  {
		  given ().param ("query", "Churchgate Station")
		    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
		    .when()
		    .get ("/maps/api/place/textsearch/json")
		    .then()
		    .contentType(ContentType.JSON)
		    .body("results[0].geometry.location",
		    		hasKey("lat"))
		    .body("results[0].types",
		    		hasItems("transit_station","train_station"))
		    .body("results[0].formatted_address",
		    		equalTo("Maharshi Karve Road, Churchgate, Mumbai, Maharashtra 400020, India"));

		  
	  }
	  
	  //@Test
	  public void logicalAssertions()  {
		  given ().param ("query", "Churchgate Station")
		    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
		    .when()
		    .get ("/maps/api/place/textsearch/json")
		    .then()
		    .contentType(ContentType.JSON)
		    .body("results[0].photos[0].height",
		    		greaterThan(2000))
		    .body("results[0].photos[0].height",
		    		lessThan(2500))
		    .body("results[0].photos[0].height",
		    		greaterThanOrEqualTo(2000))
		    .body("results[0].photos[0].height", lessThanOrEqualTo(2340))
		    .body("results[0].photos[0].height", equalTo(2340));
	  
		  
	  }
	  
	  @Test
	  public void softAssertions () {
		  
			  given ().param ("query", "Churchgate Station")
			    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
			    .when()
			    .get ("/maps/api/place/textsearch/json")
			    .then()
			    .contentType(ContentType.JSON)
			    .body("results[0].photos[0].height",
			    		greaterThan(2000),
			    		"results[0].photos[0].height",
			    		lessThan(2500),
			    		"results[0].photos[0].height",
			    		greaterThanOrEqualTo(2000),
			    		"results[0].photos[0].height", 
			    		lessThanOrEqualTo(2340),
			    		"results[0].photos[0].height", equalTo(2340));
		  
	  }

}
