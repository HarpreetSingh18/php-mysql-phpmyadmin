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

            // load the page url
            System.out.println("Loading Url");
            driver.get("http://crossbrowsertesting.github.io/login-form.html");
            
            // maximize the window - DESKTOPS ONLY
            //System.out.println("Maximizing window");
            //driver.manage().window().maximize();
            
            // complete a short login form
            // first by entering the username
            System.out.println("Entering username");
            driver.findElementByName("username").sendKeys("tester@crossbrowsertesting.com");
            
            // then by entering the password
            System.out.println("Entering password");
            driver.findElementByName("password").sendKeys("test123");
            
            // then by clicking the login button
            System.out.println("Logging in");
            driver.findElementByCssSelector("div.form-actions > button").click();
            
            // let's wait here to ensure the page has loaded completely
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logged-in-message\"]/h2")));
            
            // Let's assert that the welcome message is present on the page. 
            // if not, an exception will be raised and we'll set the score to fail in the catch block.
            String welcomeMessage = driver.findElementByXPath("//*[@id=\"logged-in-message\"]/h2").getText();
            Assert.assertEquals("Welcome tester@crossbrowsertesting.com", welcomeMessage);
            
            // if we get to this point, then all the assertions have passed
            // that means that we can set the score to pass in our system
            myTest.testScore = "pass"; 
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
