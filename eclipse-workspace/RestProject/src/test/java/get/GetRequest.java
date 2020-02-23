package get;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetRequest {
	@Test
	public void getResourceTest()
	{
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.asString());
		//display the complete response
		System.out.println(resp.then().log().all());
		//get and verify status code
		int actsc = resp.getStatusCode();
		System.out.println(actsc);
		Assert.assertEquals(200, actsc);
		//get and verify content type
		String respct = resp.getContentType();
		System.out.println(respct);
		Assert.assertEquals("application/json; charset=utf-8", respct);
		
	}

}
