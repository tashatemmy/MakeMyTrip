package makemytrippages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelSearch {
	protected WebDriver driver;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public HotelSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		
	}
	
	@FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span")
	WebElement modalClose;
	@FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/span/a")
	WebElement hotels;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div[1]/div[1]/label/span")
	WebElement cityfield;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div[1]/div[1]/div[1]/div/div/div/input")
	WebElement cityInputArea;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]")
	WebElement daypicker;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[6]")
	WebElement checkIn;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[5]")
	WebElement checkOut;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div[1]/div[4]/div[1]/div[2]/button")
	WebElement apply;
	@FindBy(xpath = "//*[@id=\"hsw_search_button\"]")
	WebElement searchButton;
	
	
	public void validHotelSearch() {
		wait.until(ExpectedConditions.visibilityOf(modalClose));
		js.executeScript("arguments[0].click();", modalClose);
		wait.until(ExpectedConditions.visibilityOf(hotels));
		hotels.click();
		wait.until(ExpectedConditions.visibilityOf(cityfield));
		cityfield.click();
		wait.until(ExpectedConditions.visibilityOf(cityInputArea));
		cityInputArea.sendKeys("Baltimore, MaryLand, United States");
		
		
		cityInputArea.sendKeys(Keys.ARROW_DOWN);
		cityInputArea.sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOf(daypicker));
		checkIn.click();
		checkOut.click();
		
		wait.until(ExpectedConditions.visibilityOf(apply));
		apply.click();
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
	}
	

}
