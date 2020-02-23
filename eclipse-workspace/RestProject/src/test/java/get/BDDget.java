package get;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BDDget {
	@Test
	public void createBDDResource()
	{
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON);
	
	}

}
