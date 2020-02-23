package post;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {
	@Test
	public void createUserTest()
	{
		//create json body
		JSONObject jobj=new JSONObject();
		jobj.put("name", "priya");
		jobj.put("job", "jobless");
		//add request property
		RequestSpecification reqsp = RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		reqsp.body(jobj.toJSONString());
		//perform post operation
		Response res = reqsp.post("https://reqres.in/api/users");
		System.out.println(res.then().log().all());
		
		
	}
	

}
