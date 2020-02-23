package post;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GitSelenium {
	//@Test
	public void getResourceTest() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/git.json");
		given()
		.auth().preemptive().basic("priyankakrishnaw@gmail.com", "prisha270419")
		.contentType(ContentType.JSON)
		.body(IOUtils.toString(fis))
		.when()
		.post("https://api.github.com/user/repos")
		.then()
		.log().all();
		
		
	}
	
	static
	{
		System.setProperty("webdriver.gecko.driver","./src/main/resources/Drivers/geckodriver.exe");
	}
	@Test
	
	public void checkRepository()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://github.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("login_field")).sendKeys("priyankakrishnaw@gmail.com");
		driver.findElement(By.id("password")).sendKeys("prisha270419");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//img[@src='https://avatars2.githubusercontent.com/u/60415061?s=40&v=4']")).click();
		driver.findElement(By.xpath("//a[@href='/Priyankakrishna3?tab=repositories']")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//div[@id='user-repositories-list']"));
		for(WebElement s:lst)
		{
			if(s.getText().contains("Hello"))
			{
				System.out.println("created");
			}
		}
		

	
		
	}
		
 		
	}
	
	


