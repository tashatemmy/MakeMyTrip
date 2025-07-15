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

public class FlightSearch {
	protected WebDriver driver;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public FlightSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[1]/ul/li[1]")
	WebElement typeOneWay;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[1]/ul/li[2]")
	WebElement typeRoundTrip;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[1]/ul/li[3]")
	WebElement typeMultiTrip;
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/label")
	WebElement fromInput;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/label")
	WebElement toInput;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[3]/label")
	WebElement departureDate1;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[4]/label")
	WebElement returnDate1;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[5]/label")
	WebElement travellersandclass;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")
	WebElement fromtextArea;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")
	WebElement totextArea;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]")
	WebElement datePicker;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[5]/div[6]/div/p[1]")
	WebElement dateAug29th;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[6]/div[1]/div/p[1]")
	WebElement dateAug31st;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[5]/div[1]/div[1]/ul[1]/li[2]")
	WebElement adult2;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/button")
	WebElement applyButton;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/p/a")
	WebElement search;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/label")
	WebElement toSecondCity;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/button")
	WebElement addAnotherCity;
	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[3]/div[2]/label")
	WebElement toThirdCity;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div/div/input")
	WebElement toTypeArea2;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[3]/div[2]/div[1]/div/div/div/input")
	WebElement toTypeArea3;
	@FindBy(xpath ="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]/div/p")
	WebElement date25th;
	@FindBy(xpath ="")
	WebElement anotherDeparture2;
	@FindBy(className = "datePickerContainer")
	WebElement dateContainer;
	
	
	
	public void validOneWayFlightSearch() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(typeOneWay));
		typeOneWay.isSelected();
//	From city script
		action.moveToElement(fromInput).perform();
		fromInput.click();
		wait.until(ExpectedConditions.visibilityOf(fromtextArea));
		fromtextArea.sendKeys("harrisburg, PA");
		Thread.sleep(2000);
		int i;
		for(i = 1; i <= 5; i++) {
			fromtextArea.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		}
		fromtextArea.sendKeys(Keys.ENTER);
//	To City script
		toInput.click();
		wait.until(ExpectedConditions.visibilityOf(totextArea));
		totextArea.sendKeys("syracuse, NY");
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ENTER);
//	Departure Date script
		wait.until(ExpectedConditions.visibilityOf(datePicker));
		action.moveToElement(datePicker).perform();
		datePicker.click();
		js.executeScript("arguments[0].click()", dateAug29th);
//	Traveler,Class script
		action.moveToElement(travellersandclass).perform();
		
		search.click();
	}
	
	
	public void validRoundTripFlightSearch() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(typeRoundTrip));
		typeRoundTrip.click();
//	From city script
		action.moveToElement(fromInput).perform();
		fromInput.click();
		wait.until(ExpectedConditions.visibilityOf(fromtextArea));
		fromtextArea.sendKeys("Minneapolis");
		Thread.sleep(1000);
		fromtextArea.sendKeys(Keys.ENTER);
//	To City script
		toInput.click();
		wait.until(ExpectedConditions.visibilityOf(totextArea));
		totextArea.sendKeys("Newark");
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ENTER);
//	Departure and Return dates
		wait.until(ExpectedConditions.visibilityOf(datePicker));
		action.moveToElement(datePicker).perform();
		datePicker.click();
		js.executeScript("arguments[0].click()", dateAug29th);
		js.executeScript("arguments[0].click()", dateAug31st);
//	Traveler, class script
		action.moveToElement(travellersandclass).perform();
		wait.until(ExpectedConditions.visibilityOf(travellersandclass));
		travellersandclass.click();
		wait.until(ExpectedConditions.visibilityOf(adult2));
		js.executeScript("arguments[0].click()", adult2);
		action.moveToElement(applyButton).perform();
		applyButton.click();
		
		
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
					
	}
	
	public void invalidCityInput(String city1) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(typeOneWay));
		typeOneWay.isSelected();
//	From city script
		action.moveToElement(fromInput).perform();
		fromInput.click();
		wait.until(ExpectedConditions.visibilityOf(fromtextArea));
		fromtextArea.sendKeys(city1);
		Thread.sleep(1000);
		fromtextArea.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		fromtextArea.sendKeys(Keys.ENTER);
//	to city script
		toInput.click();
		wait.until(ExpectedConditions.visibilityOf(totextArea));
		totextArea.sendKeys(city1);
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOf(search));
		action.moveToElement(search).perform();
		search.click();						
		
	}
	
	public void validMultiCityFlightSearch(String city3, String city4) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(typeMultiTrip));
		typeMultiTrip.click();
		/**
//	From city script
		wait.until(ExpectedConditions.visibilityOf(fromInput));
		action.moveToElement(fromInput).perform();
		fromInput.click();
		wait.until(ExpectedConditions.visibilityOf(fromtextArea));
		fromtextArea.sendKeys(city1);
		Thread.sleep(1000);
		fromtextArea.sendKeys(Keys.ENTER);
//	To City script
		toInput.click();
		wait.until(ExpectedConditions.visibilityOf(totextArea));
		totextArea.sendKeys(city2);
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		totextArea.sendKeys(Keys.ENTER);
		**/
//	To Another City1
		wait.until(ExpectedConditions.visibilityOf(toSecondCity));
		action.moveToElement(toSecondCity).perform();
		toSecondCity.click();
		wait.until(ExpectedConditions.visibilityOf(toTypeArea2));
		toTypeArea2.sendKeys(city3);
		toTypeArea2.sendKeys(Keys.ARROW_DOWN);
		toTypeArea2.sendKeys(Keys.ENTER);
		action.moveToElement(date25th).perform();
		wait.until(ExpectedConditions.visibilityOf(date25th));
		date25th.click();
		
		
// Add Another City button
		action.moveToElement(addAnotherCity).perform();
		addAnotherCity.click();
		action.moveToElement(toThirdCity).perform();
		toThirdCity.click();
		wait.until(ExpectedConditions.visibilityOf(toTypeArea3));
		toTypeArea3.sendKeys(city4);
		toTypeArea3.sendKeys(Keys.ARROW_DOWN);
		toTypeArea3.sendKeys(Keys.ENTER);
		js.executeScript("arguments[0].scrollTop = arguments[1];", dateContainer, 700);
		action.moveToElement(date25th).perform();
		wait.until(ExpectedConditions.visibilityOf(date25th));
		date25th.click();
		
		search.click();
		
		
	}

	
	

}
