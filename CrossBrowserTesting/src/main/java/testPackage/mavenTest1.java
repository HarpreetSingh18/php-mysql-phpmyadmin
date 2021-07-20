package testPackage;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class mavenTest1 {  
public String baseUrl = "https://www.javatpoint.com/";  
String driverPath = "C:/Selenium/selenium-java-3.141.49/chrome_driver91/chromedriver.exe";  
public WebDriver driver ;   
@Test             
public void test() {      
// set the system property for Chrome driver      
try {
	System.setProperty("webdriver.chrome.driver", driverPath);  
	// Create driver object for CHROME browser  
	driver = new ChromeDriver();  
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
	driver.manage().window().maximize();  
	driver.get(baseUrl);  
	// get the current URL of the page  
	String URL= driver.getCurrentUrl();  
	System.out.print("Current url is : "+URL);  
	//get the title of the page  
	String title = driver.getTitle();                  
	System.out.println(title);
	System.out.println("Title of the page is: " + driver.getTitle());
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("//body/div[@id='page']/div[@id='container']/div[@id='link']/div[1]/ul[1]/li[2]/a[1]")).click();
	Thread.sleep(5000);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}  
}     

@BeforeTest  
public void beforetest() {  

System.out.println("beforetest ");
}
 
@AfterTest  
public void afterTest() {  
driver.quit();  
System.out.println("After test End Javapoint");
}         
}  