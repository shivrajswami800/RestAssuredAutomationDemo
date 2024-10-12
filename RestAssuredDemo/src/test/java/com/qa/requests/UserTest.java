package com.qa.requests;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;

public class UserTest 
{
	@Test
	public void getTest()
	{
		UserEndPoints.getUser();
	}
	
	@Test
	public void postTest()
	{
		UserEndPoints.createUser();
	}
	
	public void authTest()
	{
		UserEndPoints.authTest();
	}

}
