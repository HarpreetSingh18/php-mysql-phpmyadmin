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
	    String myProjectARN = "arn:aws:devicefarm:us-west-2:158020277455:testgrid-project:ddf9511c-fcbf-43ce-9d09-e190558ff601";
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
		  driver.get("https://www.edureka.co/");
		  Thread.sleep(4000);
		  driver.quit();
	  }
	  
	
	  
	  
	  @AfterGroups
	  void tearDown() {
	    // make sure to close your WebDriver:
	    driver.quit();
	  }

}


