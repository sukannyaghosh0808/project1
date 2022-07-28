package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() 
	{
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\Sukannya Ghosh\\eclipse-workspace\\freeCRM\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
		public static void setup() 
		{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUKANNYA GHOSH\\eclipse-workspace\\freeCRM\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Please open a proper browser!");
		}
		
		driver.get(prop.getProperty("url"));
		//maximise screen
		driver.manage().window().maximize();
		//wait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	}
	


