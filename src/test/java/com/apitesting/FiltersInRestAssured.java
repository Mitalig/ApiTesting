package com.apitesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class FiltersInRestAssured {

	public  StringWriter requestWriter;
	public  PrintStream  requestCapture;
	
	public  StringWriter responseWriter;
	public  PrintStream  responseCapture;
	
	public  StringWriter errorWriter;
	public  PrintStream  errorCapture;
	
	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "https://maps.googleapis.com";
	    requestWriter = new StringWriter();
		requestCapture =  new PrintStream(new WriterOutputStream(requestWriter),true);
	    
	    responseWriter = new StringWriter();
	    responseCapture = new PrintStream(new WriterOutputStream(responseWriter),true);

	    errorWriter = new StringWriter();
	    errorCapture = new PrintStream(new WriterOutputStream(errorWriter),true);

		
	  }
	
	
	  
	  @Test
	  public void singleAssertion()  {
		 
		 RestAssured.given ()
		 .filter(new RequestLoggingFilter(requestCapture))
		 .filter(new ResponseLoggingFilter(responseCapture))
	    .param ("query", "Churchgate Station")
	    .param ("key", "AIzaSyBrhdZP1wWpMXVEvzpY4-3W-FKieCYhVXg")
	    .when()
	    .get ("/maps/api/place/textsearchs/json").
	     then()
	    .contentType(ContentType.JSON)
	    .root("results[0].geometry.viewport.northeast")
	    .body("lat",
	    		notNullValue(),"lng",notNullValue())
	   .root("results[0].geometry.viewport.southwest")
	   .body("lat",
	    		notNullValue(),"lng",notNullValue());
	   
	   System.out.println(requestWriter.toString());
	   System.out.println(responseWriter.toString());
	   System.err.println(errorWriter.toString());

	  }	 
	
	
}
