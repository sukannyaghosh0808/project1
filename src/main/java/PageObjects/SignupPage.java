package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class SignupPage extends BaseClass{
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signupButton;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement logo;
	
	@FindBy(name="email")
	WebElement email;
	
	public SignupPage()
	{
		PageFactory.initElements(driver, this);
	}

	public Boolean LogoCheck()
	{
		return logo.isDisplayed();
	}
	public void signupButtonclick()
	{
		signupButton.click();
	}
	public Boolean signupButtonCheck()
	{
		return signupButton.isEnabled();
	}
	
	public WebElement email()
	{
		return email;		
	}
}
