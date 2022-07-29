package TestRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;
import PageObjects.loginPage;

public class loginPageTest extends BaseClass {
	
	static loginPage pg;	
	static ExtentReports report; 
	static ExtentTest test;
	
	//why we need to use super here? this constructor came automatically
	public loginPageTest() throws IOException {
		super();		
	}
	
	@BeforeClass
	public void openTest()
	{
		report = new ExtentReports("C:\\Users\\SUKANNYA GHOSH\\eclipse-workspace\\freeCRM\\Reports\\login.html", true);
		test = report.startTest("Login Page");		
	}
	
	@AfterClass 
	public static void closeTest()
	{
	  report.endTest(test);
	  report.flush();	
	}
	
	@BeforeTest
	public static void setUp() throws IOException
	{
		setup();		 
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@Test(priority=1)
	public static void verifyTitle()
	{
		pg= new loginPage();
		String title = pg.getTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");	
	}
	
	@Test(priority=2)
	public static void LoginButtonTest()
	{
		pg=new loginPage();
		Boolean flag = pg.loginButton().isDisplayed();
		if(flag==true)
		{
			 test.log(LogStatus.PASS,"Test case passed");    
		}
		else 
		{
			test.log(LogStatus.FAIL,"Test case passed");    
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public static void loginClick()
	{
		pg=new loginPage();
		pg.loginButton().click();
		//Assert.assertTrue(pg.loginButton().isDisplayed(),"login button not working");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
	}

}
