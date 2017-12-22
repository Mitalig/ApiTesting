package com.apitesting;

import static org.hamcrest.Matchers.notNullValue;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class ErrorFilterInRestAssured {
	
	
	public StringWriter errorWriter;
	public PrintStream errorCapture;
	
	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://maps.googleapis.com";
        errorWriter = new StringWriter();
        errorCapture = new PrintStream(new WriterOutputStream(errorWriter));
		
	  }
	
	 @Test
	  public void singleAssertion()  {
		 
		 RestAssured.given ()
		 .filter(new ErrorLoggingFilter(errorCapture))
	    .param ("query", "Churchgate Station")
	    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
	    .when()
	    .get ("/maps/api/place/textsearchs/json").
	     then()
	    .root("results[0].geometry.viewport.northeast")
	    .body("lat",
	    		notNullValue(),"lng",notNullValue())
	   .root("results[0].geometry.viewport.southwest")
	   .body("lat",
	    		notNullValue(),"lng",notNullValue());
	   
	   System.out.println(errorWriter.toString());

	  }	 
	

}
