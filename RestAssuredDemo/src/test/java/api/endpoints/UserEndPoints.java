package api.endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import com.beust.jcommander.ResourceBundle;

public class UserEndPoints 
{	
	//Post Method Automation
	public static void createUser()
	{
		//Creating Payload
		HashMap data1 = new HashMap();
		data1.put("name", "Ram");
		data1.put("job", "Peon");
		
		//Passing pre requisites
		given()
		.contentType("application/json")	
		.body(data1)
		
		//hit the url
		.when()
		.post(Routes.postUrl)
		
		//Validation
		.then()
		.statusCode(201)
		.log().all();
	}
	
	//Get Method Automation
	public static void getUser()
	{
		
		
		given()
		.contentType("")
		.when()
		.get(Routes.getUrl)
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
	
	//Token generation and Automation
	public static void authTest()
	{
		given()
		.auth().basic("postman","password")
		.when()
		.get(Routes.authUrl)
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}

}
