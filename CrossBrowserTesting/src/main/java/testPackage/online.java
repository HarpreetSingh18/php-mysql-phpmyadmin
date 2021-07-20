package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class online {
	String driverPath = "C:\\Selenium\\selenium-java-3.141.49\\chrome_driver91\\chromedriver.exe";
	public String baseUrl = "https://www.edureka.co/";
	public WebDriver driver;
	static int i = 0;
	//public Actions action;
	
	//Actions action = new Actions(driver);
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching chrokme browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		//WebDriver driver ;
		driver = new ChromeDriver();
		//action = new Actions(driver);
		driver.get(baseUrl);
		
		
	}
	@Test(priority=0)
	public void LoggingIn() throws InterruptedException {
		//Actions action = new Actions(driver);
		driver.findElement(By.xpath("//header/nav[1]/ul[1]/li[4]/span[1]")).click();
		
		//action.moveToElement(driver.findElement(By.id("si_popup_email")));
		//driver.findElement(By.id("si_popup_email")).click();
		driver.findElement(By.id("si_popup_email")).sendKeys("najoje3364@zefara.com");
		Thread.sleep(2000);
		//action.click();
		//action.sendKeys("najoje3364@zefara.com");
		Thread.sleep(1000);
		//action.build().perform();
		//action.moveToElement(driver.findElement(By.id("si_popup_passwd")));
		//action.click();
		//action.sendKeys("Najoje3364@z");
		driver.findElement(By.id("si_popup_passwd")).click();
		driver.findElement(By.id("si_popup_passwd")).sendKeys("Najoje3364@z");
		Thread.sleep(1000);
		//action.build().perform();
		//action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Login')]")));
		//action.click();
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority=1)
	public void userprofile() throws InterruptedException {
		
		WebDriverWait waitElement = new WebDriverWait(driver,20);
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/nav[1]/div[4]/ul[1]/li[6]/a[1]/span[2]/img[1]")));

		driver.findElement(By.xpath("//header/nav[1]/div[4]/ul[1]/li[6]/a[1]/span[2]/img[1]")).click();
		Thread.sleep(1000);
		waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'My Profile')]")));
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		String Pagetitle = driver.getTitle();
		System.out.println("Page Title is : "+ Pagetitle);
	}
	
	@Test(priority=2)
	public void ClickEditingDetail() throws InterruptedException {
		driver.findElement(By.xpath("//body/app-root[1]/app-profile-main[1]/div[1]/div[1]/div[2]/app-myprofilenew[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
	
	}
	
	@Test(priority=3)
	public void EditingPersonalDetail() throws InterruptedException {
		WebElement name = driver.findElement(By.xpath("//input[@id='fullName']"));
		name.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "Hero");
		WebElement Experience = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/ngx-select-dropdown[1]/div[1]/button[1]/span[1]"));
		//action.click(Experience).build().perform();
		Experience.click();
		WebElement ExperienceYR = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/ngx-select-dropdown[1]/div[1]/div[1]/ul[2]/li[@tabindex='-1']"));
		//action.click(ExperienceYR).build().perform();
		ExperienceYR.click();
		Thread.sleep(2000);
		
		//WebElement industry = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]"));
		/*action.moveToElement(industry)
		.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.click().build().perform();*/
		
		Thread.sleep(2000);
		//Actions action = new Actions(driver);
		WebElement designation = driver.findElement(By.xpath("//input[@id='designation']"));
		//action.click(designation).sendKeys("Tester").build().perform();
		designation.click();
		designation.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "Test Automation");
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void ContactTIme() throws InterruptedException {
		//Actions action = new Actions(driver);

		WebElement weekendTime =  driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[2]/div[2]/div[1]/ngx-select-dropdown[1]/div[1]/button[1]/span[1]"));
		//action.click(weekendTime).build().perform();
		weekendTime.click();
		WebElement weekendTimeStart =driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[2]/div[2]/div[1]/ngx-select-dropdown[1]/div[1]/div[1]/ul[2]/li[3]"));
		//action.click(weekendTimeStart).build().perform();
		weekendTimeStart.click();
		Thread.sleep(2000);
		WebElement WeekendTimeEnd = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[2]/div[2]/div[2]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]"));
		//action.click(WeekendTimeEnd).build().perform();
		WeekendTimeEnd.click();
		WebElement weekendTimeEndSelect = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[2]/div[2]/div[2]/ngx-select-dropdown[1]/div[1]/div[1]/ul[2]/li[6]"));
		//action.click(weekendTimeEndSelect).build().perform();
		weekendTimeEndSelect.click();
		WebElement WeekendSave = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[1]/button[1]"));
		//action.click(WeekendSave).build().perform();
		
		Thread.sleep(2000);

	}
	
	@Test(priority=5)
	public void LearningGoals() throws InterruptedException {
		//Actions action = new Actions(driver);

		WebElement Goal = driver.findElement(By.xpath("//label[contains(text(),'Improve in current job')]"));
		//action.click(Goal).build().perform();
		Goal.click();
		Thread.sleep(2000);
		WebElement CareerGoal = driver.findElement(By.xpath("//textarea[@id='goal']"));
		CareerGoal.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "My goal is my goal");

		//action.click(CareerGoal)
		//.keyDown(org.openqa.selenium.Keys.CONTROL)
		//.sendKeys("a").sendKeys(Keys.BACK_SPACE)
		//.keyUp(org.openqa.selenium.Keys.CONTROL)
		//.sendKeys("Being manager of product based company").build().perform();
		Thread.sleep(2000);

	}
	
	@Test(priority=6)
	public void ReminderBuddy() throws InterruptedException {
		//Actions action = new Actions(driver);

		WebElement ReminderName = driver.findElement(By.xpath("//input[@id='partnerName']"));
		WebElement ReminderEmail = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/input[1]"));
		WebElement ReminderMobile = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
		WebElement ReminderSave = driver.findElement(By.xpath("//body/app-root[1]/app-onboarding-user-details[1]/section[1]/div[2]/div[1]/div[2]/button[1]"));
		Thread.sleep(2000);
		ReminderName.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "Friend");
		ReminderEmail.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "tatu@gmail.com");
		ReminderMobile.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "9867483644");
		//action.click(ReminderSave);

	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("In Test : " +i);
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		i+=1;
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}
