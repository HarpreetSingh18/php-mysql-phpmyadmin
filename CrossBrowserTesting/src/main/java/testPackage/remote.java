package testPackage;
import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class remote {

	static String username = "yogesh.nain%40testingxperts.com"; // Your username
    static String authkey = "u04bf018fea08c49";  // Your authkey
    String testScore = "unset";
    @Test
    public void check() throws Exception {
        remote myTest = new remote();

        DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("name", "Login Form Example");
        caps.setCapability("build", "1.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "72");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("screenResolution", "1366x768");
        caps.setCapability("record_video", "true");
        caps.setCapability("record_network", "false");

        
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
        System.out.println(driver.getSessionId());

        try {
		
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
        catch(AssertionError ae) {

            // if we have an assertion error, take a snapshot of where the test fails
            // and set the score to "fail"
            
            myTest.testScore = "fail";
        } 
        finally {

            System.out.println("Test complete: " + myTest.testScore);

            // here we make an api call to actually send the score 
            //myTest.setScore(driver.getSessionId().toString(), myTest.testScore);
            
            // and quit the driver
            driver.quit();
        }
}
    
}
