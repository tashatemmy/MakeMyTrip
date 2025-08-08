package makemytriptests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import makemytrippages.Login;

public class LoginTest extends Base {
	@Test(groups = {"login", "smoke", "regression", "positive"}, priority = 1)
	public void validLoginTest() {
		Login login = new Login(driver);
		login.validCreateAccount();
		
	}
	
	@Test(groups = {"login", "regression", "negative"}, priority = 2)
	public void invalidPasswordTest() {
		Login login = new Login(driver);
		login.invalidpasswordLogin();
		
	}
	
	@Test(groups = {"login", "regression", "negative"}, priority = 3)
 	public void invalidMobileTest() {
		Login login = new Login(driver);
		login.invalidmobileLogin();
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
        if (env.equalsIgnoreCase("useBrowserstack") && result.getStatus() == ITestResult.SUCCESS) {
            ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"passed\", \"reason\": \"QC Passed - All validations successful.\"}}");
        } else if (env.equalsIgnoreCase("useBrowserstack") && result.getStatus() == ITestResult.FAILURE) {
            ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"QC Failed - Test failed due to: " + result.getThrowable() + "\"}}");
        }
        if (driver != null) {
            driver.quit();
        }
	}
	
}


