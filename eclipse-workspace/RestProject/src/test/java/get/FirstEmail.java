package get;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class FirstEmail {
	@Test
	public void getFirstEmail()
	{
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		//display the complete response
		System.out.println(res.then().log().all());
		//navigate to all response json file and capture all first email
		String email = res.jsonPath().get("data[0].email");
		System.out.println(email);
		Assert.assertEquals("michael.lawson@reqres.in",email);
		
	}

}
