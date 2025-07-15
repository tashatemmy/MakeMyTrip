package makemytrippages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelSearch {
	protected WebDriver driver;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public HotelSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

}
