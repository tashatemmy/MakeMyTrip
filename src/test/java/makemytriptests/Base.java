package makemytriptests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	protected WebDriver driver;
	String browser;
	String url;
	
	@BeforeMethod
	public void browserSetup() {
		url = "https://makemytrip.global";
		browser = "chrome";
		
		if(browser.equals("chrome")) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		}else {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
		}
	}


}
