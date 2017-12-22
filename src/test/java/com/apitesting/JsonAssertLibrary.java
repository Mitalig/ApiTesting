package com.apitesting;

import static io.restassured.RestAssured.given;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JsonAssertLibrary {
	
	
	
	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://maps.googleapis.com";
	  }
	
	  
	  @Test
	  public void jsonAssert() throws Exception  {
	   try  {
		  
	  String expected = new String(Files.readAllBytes(Paths.get("/Users/ashwin/work/learning/com.apitesting/resources/JsonAssert.txt")));	  
	   String actual = given ().param ("query", "Churchgate Station")
	    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
	    .when()
	    .get ("/maps/api/place/textsearch/json").asString();
	  
	  // System.out.println(expected);
	   System.out.println(actual);
	   JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
	  
	   }
	   catch(Exception e)  {
		   
	   }
	  }
	
	

}
