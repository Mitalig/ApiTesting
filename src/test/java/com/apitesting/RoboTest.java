package com.apitesting;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class RoboTest {

	
	@org.testng.annotations.Test
	public void Test ()  {
		
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("turtlemint");
		
		DBCollection collection = db.getCollection("Activity");

		String json = getAllData("/Users/ashwin/work/learning/com.apitesting/Resources/data.txt");
		
		org.bson.Document doc = org.bson.Document.parse(json);

		DBObject dbObject = (DBObject)JSON.parse(doc.toJson());

			collection.insert(dbObject);

	}
	
	public static String getAllData(String fileName) {

		try {

			return new String(Files.readAllBytes(Paths.get(fileName)));

		}
		catch (Exception e) {

			
		}
		return "";

	}
}
