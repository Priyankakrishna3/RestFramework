package post;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostComplex {
	@Test
	public void createJsonComplex() throws IOException
	{
		//get location of json file
		FileInputStream fis=new FileInputStream(new File("./src/test/resources/jdata.json"));
		//add request property
		RequestSpecification reqsp = RestAssured.given();
		reqsp.body(IOUtils.toString(fis));
		//post operation
		Response resp = reqsp.post("https://reqres.in/api/users");
		System.out.println(resp.then().log().all());
		
		

	
		
		
		
	}

}
