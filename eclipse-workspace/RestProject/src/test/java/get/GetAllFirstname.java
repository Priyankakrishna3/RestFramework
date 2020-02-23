package get;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllFirstname {
	@Test
	public void getFirstName()
	{
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		//display complete response
		System.out.println(resp.then().log().all());
		//navigate to all response json fileand capture all the first name
		List<Object> lst = resp.jsonPath().get("data.first_name");
		System.out.println(lst);
		boolean status=false;
		for(Object obj:lst)
		{
			System.out.println(obj);
			if(obj.equals("George"))
			{
				System.out.println("pass==is available");
				status=true;
				break;
			}
		}
		
	}

}
