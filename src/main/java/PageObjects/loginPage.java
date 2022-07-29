package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class loginPage extends BaseClass {
	
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
		
	//(driver,this) what is the use of this?
		public loginPage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	//Methods 
	public String getTitle()
	{
		return driver.getTitle();		
	}
	
	public WebElement loginButton()//do i need to perform the actions in page class	                              
	{								//or in test class?		
		return login;
    }

	
	 
	
	
	

}
