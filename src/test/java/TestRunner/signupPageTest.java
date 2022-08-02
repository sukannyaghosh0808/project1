package TestRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BasePackage.BaseClass;
import PageObjects.SignupPage;
import Utilities.JSONReader;

public class signupPageTest extends BaseClass {
	
	static SignupPage sg;
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeTest
	public void setUp() {
		setup();
		System.out.println("signup page browser opened---PASSED");
	}
	
	@AfterTest
	public static void tearDown() {
		driver.quit();
		System.out.println("signup page browser CLOSED---PASSED");
	}
	
	@BeforeClass
	public static void openTestReport() {
		report = new ExtentReports("C:\\Users\\SUKANNYA GHOSH\\eclipse-workspace\\project1\\Reports\\signUp.html",true);
		test= report.startTest("Sign up page");
	}
	
	@AfterClass
	public static void closeTest(){
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=0)
	public static void logoTest() {
		sg=new SignupPage();
		Boolean flag=sg.LogoCheck();
		if(flag==true)
		{
			test.log(LogStatus.PASS, "Logo is displayed");
		}		
		System.out.println("1 sign up Logo check done---PASSED");
	}
	
	@Test(priority=1)
	public static void signupButtonClickTest() {
		sg=new SignupPage();
		if(sg.signupButtonCheck().equals(true))
		{
			test.log(LogStatus.PASS, "signup button is clickable");
		}
		System.out.println("2 sign up button check done---PASSED");
	}
	
	@Test(priority=2)
	public static void signupButtonTest() {
		sg=new SignupPage();
		sg.signupButtonclick();	
		System.out.println(" 3 sign up click---PASSED");
		
	}
	
	@Test(priority=3)
	public static void signupTest() throws IOException, ParseException
	{
		JSONReader rd = new JSONReader();
		String email= rd.readData("email");
		//System.out.print(email);
		
		sg=new SignupPage();
		sg.email().sendKeys(email);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("4 sign up page email sent--PASSED");
	}
}
