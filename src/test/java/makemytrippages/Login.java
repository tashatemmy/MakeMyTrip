package makemytrippages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	protected WebDriver driver;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	
	@FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section")
	WebElement createAccountForm;
	@FindBy(xpath ="//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[1]/div/input")
	WebElement emailMobileInput;
	@FindBy(xpath ="//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button")
	WebElement continueButton;
	@FindBy(id = "password")
	WebElement accountPassword;
	@FindBy(xpath ="//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button")
	WebElement login;
	@FindBy(xpath ="//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/div[1]/div/span")
	WebElement close;
	
	String email = "temmydiva21@gmail.com";
	String password = "Tashatemmy21$";
	String invalidPword = "Tashatemmy";
	String invalidNumber = "22224444789";
	String invalidText = "Either Username or Password is incorrect";
	String invalidPhoneText = "Invalid phone number";
	
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
	}
	
	public void validCreateAccount() {
	wait.until(ExpectedConditions.visibilityOf(createAccountForm));
	createAccountForm.isDisplayed();
	emailMobileInput.sendKeys(email);
	wait.until(ExpectedConditions.elementToBeClickable(continueButton));
	continueButton.click();
	wait.until(ExpectedConditions.visibilityOf(accountPassword));
	accountPassword.sendKeys(password);
	wait.until(ExpectedConditions.elementToBeClickable(login));
	login.click();
	wait.until(ExpectedConditions.visibilityOf(close));
	js.executeScript("arguments[0].click()", close);
	
		
	}
	
	public void invalidpasswordLogin() {
		wait.until(ExpectedConditions.visibilityOf(createAccountForm));
		createAccountForm.isDisplayed();
		emailMobileInput.sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		wait.until(ExpectedConditions.visibilityOf(accountPassword));
		accountPassword.sendKeys(invalidPword);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		wait.until(ExpectedConditions.textToBePresentInElement(createAccountForm, invalidText));
		wait.until(ExpectedConditions.visibilityOf(login));
		js.executeScript("arguments[0].remove()", createAccountForm);
	}
	
	public void invalidmobileLogin() {
		wait.until(ExpectedConditions.visibilityOf(createAccountForm));
		createAccountForm.isDisplayed();
		emailMobileInput.sendKeys(invalidNumber);
		continueButton.click();
		wait.until(ExpectedConditions.textToBePresentInElement(createAccountForm, invalidPhoneText));
	}
	
	
	

}

