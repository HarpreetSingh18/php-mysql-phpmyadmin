package test;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.*;
import software.amazon.awssdk.services.devicefarm.model.*;

import java.awt.Window;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazonaws.util.Platform;



public class remote {
	
	private static RemoteWebDriver driver;
	public String baseUrl = "https://www.google.co.in/";  
	  @Test(priority = 0)
	  public void setUp() throws MalformedURLException, InterruptedException {
	    String myProjectARN = "arn:aws:devicefarm:us-west-2:566333853275:testgrid-project:6ce5c098-b2be-44de-bcb7-d1dfdb7b59c6";
	    DeviceFarmClient client  = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
	    CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
	      .expiresInSeconds(300)
	      .projectArn(myProjectARN)
	      .build();
	    CreateTestGridUrlResponse response = client.createTestGridUrl(request);
	    URL testGridUrl = new URL(response.url());
	    // You can now pass this URL into RemoteWebDriver.
	    DesiredCapabilities cap = new DesiredCapabilities();
	    cap.chrome();
	    cap.setBrowserName("chrome");
	    //org.openqa.selenium.Platform Platform = null;
		//cap.setPlatform(Platform.WINDOWS);
		
	    WebDriver driver = new RemoteWebDriver(testGridUrl, cap);
	    driver.manage().window().maximize(); 
		  driver.get("http://34.201.99.203:30001/");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
		  System.out.println("Clicked on Add new Employee");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//input[@name='name']")).click();
		  driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Yogesh Nain");
		  System.out.println("Added name");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//textarea[@name='address']")).click();
		  driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("97 Devilal Colony TCP 2 Hisar Cantt Hisar Haryana 125006");
		  System.out.println("Added Address");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//input[@name='salary']")).click();
		  driver.findElement(By.xpath("//input[@name='salary']")).sendKeys("15000");
		  System.out.println("Entered Salary");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  System.out.println("Record Added");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//a[@href='read.php?id=4']")).click();
		  System.out.println("View Record of Sandeep");
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//a[contains(text(), 'Back')]"));
		  System.out.println("Back To HomePage");
		  Thread.sleep(4000);
	  }
	  
	
	  
	  
	  @AfterGroups
	  void tearDown() {
	    // make sure to close your WebDriver:
	    driver.quit();
	  }

}


