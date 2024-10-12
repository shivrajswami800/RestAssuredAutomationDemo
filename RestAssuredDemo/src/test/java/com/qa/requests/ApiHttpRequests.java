package com.qa.requests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class ApiHttpRequests 
{

	int id;
	@Test
	public void getuser()
	{
		given()
		.contentType("")
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

	@Test
	public void postUser()
	{
		HashMap data = new HashMap();
		data.put("name", "Raman");
		data.put("job", "Teacher");
		
		id=given()
		.contentType("application/json")		
		.body(data)		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		/*.then()
		.assertThat()
		.statusCode(201)					
		.log().all();*/
		
	
	}
	@Test(priority=1,dependsOnMethods={"postUser"})
	public void updateReq()
	{
		HashMap data1 = new HashMap();
		data1.put("name", "Ram");
		data1.put("job", "Peon");
		
		given()
		.contentType("application/json")	
		.body(data1)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	@Test
	public void authTest()
	{
		//basic,bearer,auth1.0,1.2,JWT
		
		
		
	}
	
	/*@Test
	public void validateResponse()
	{
		Response res = (Response) given()
		.contentType("")
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		//JSONObject jo = new JSONObject(res.toString());
		
		//System.out.println(jo);
		
         
		
	}*/
}
