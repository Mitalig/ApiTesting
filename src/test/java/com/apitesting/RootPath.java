package com.apitesting;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RootPath {

	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://maps.googleapis.com";
	  }
	  
	  @Test
	  public void singleAssertion()  {
	   given ().param ("query", "Churchgate Station")
	    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
	    .when()
	    .get ("/maps/api/place/textsearch/json")
	    .then()
	    .contentType(ContentType.JSON)
	    .root("results[0].geometry.viewport.northeast")
	    .body("lat",
	    		notNullValue(),"lng",notNullValue())
	   .root("results[0].geometry.viewport.southwest.lng")
	   .body("lat",
	    		notNullValue(),"lng",notNullValue());

	  }	  
}
