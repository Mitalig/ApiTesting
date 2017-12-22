package com.apitesting;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;


public class GetRequestTest {

 @Test
  public void test ()  {
	  
	  int fileSize;
	  File filePath =  new File (System.getProperty("user.dir")+"/resources/rest-assured-3.0.5-dist.zip");
	  
	  fileSize = (int)filePath.length();
	  
	  System.out.println("The actual value is "+fileSize);

	  
	  byte [] expectedValue =
			  given ()
			  .get("http://dl.bintray.com/johanhaleby/generic/rest-assured-3.0.5-dist.zip")
			  .asByteArray();
	  System.out.println("The expected value is "+expectedValue.length);

	  Assert.assertEquals(fileSize, expectedValue.length);
	  
  }
  
  
 /*//@Test
  public void testResult ()  {
    Response res  =given ().param ("reg2", "01")
    .param ("reg1", "mh")
    .param ("reg3", "hh")
    .param ("reg4", "2323")
    .param ("vertical", "car")
    .when()
    .get ("/api/registrationresult")
    .then()
    .contentType(ContentType.JSON)
    .extract().response();
    
    System.out.print(res.asString());
    
  }
  
  
  
  //@Test
  public void getOAuthCode ()  {
    
  	Response res= given()
  			.param("state", "welcome321")
  			.param("scope", "user")
  			.param("code", "ec283c583dd62107497f")
    .auth()
    .preemptive()
    .basic("3f8ccad23d90d62dc7d0", "346b9c7588197ab8549df08131929f2feacf2205")
  			.post("https://github.com/login/oauth/access_token")
  	.then()
  	.extract()
  	.path("access_token");
  	
  	
  	
  	
  	Response res1=given()
  	.accept(ContentType.JSON)
  	.auth()
  	.oauth2(res.toString())
  	.when()
  	.get("https://api.github.com/user")
  	.then()
  	.extract()
  	.response();
  	
  	System.out.println(res1);
  	
  	
    
  }
  
  //@Test
  public void testResult2 ()  {

  	Response res= given()
  			.param("state", "welcome321")
  			.param("scope", "user")
  			.param("code", "ec283c583dd62107497f")
    .auth()
    .preemptive()
    .basic("786461414109-b7d3kp8q3g5o9tllvtomaatninqg7tnk", "n-FCOtrDxhe53ExP_AcNdSuH")
  			.post("https://accounts.google.com/o/oauth2/v2/auth")
  	.then()
  	.extract().response();
  }
  
 //@Test
 public void testResult1 ()  {
   
		Response postResponse = given()
				.multiPart(new File("/Users/ashwin/Downloads/open-graph-default.png"))
		    .post("http://turtlemint.dev.mintpro.in/api/uploadImages").then().statusCode(200)
		    .extract().response();
		
		System.out.println(postResponse.asString());
   
 }
 
  public String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
  
  String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
  
  public Map<String, Object> mapReturns(String json)  {
	  Map<String, Object> retMap = new Gson().fromJson(
			    json, new TypeToken<HashMap<String, Object>>() {}.getType()
			);
	  
	  return retMap;
  }
  
//  @Test() 
  public void testPostResult () throws IOException  {
	  
	//File file = new File("/Users/ashwin/work/learning/com.apitesting/JsonFiles/db.json");
	  	 
	//String json =readFile("/Users/ashwin/work/learning/com.apitesting/JsonFiles/db.json");
	String line2 = Files.readAllLines(Paths.get("/Users/ashwin/work/learning/com.apitesting/JsonFiles/db.json")).get(1);

	System.out.println(line2);
	 //String test= mapReturns(json);
	 SendQuotes sq = new SendQuotes();
	 sq.setrequestId("AF3939MTU69");
	 sq.setaction("sendQuote");
	 sq.seturl("http://www.planturtle.com/car-insurance/results/AF3939MTU69");
	 sq.setuserEmail("simta.s@turtlemint.com");
	 sq.setuserMobile("9619391246");
	 sq.setutmMedium("(none)");
	 sq.setutmSource("(direct)");
	 sq.setvertical("car");
	  given().body (line2)
	    .when ().contentType(ContentType.JSON)
	    .post ("http://www.planturtle.com/api/sendQuote")
	    .then()
	    .assertThat().statusCode(200);
	 //System.out.println(res.asString());

	
  }
  */
}