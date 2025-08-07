package makemytriptests;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import makemytrippages.HotelSearch;

public class HotelSearchTest extends Base {
	
	@Test
	public void validHotelSearchTest() {
		HotelSearch hs = new HotelSearch(driver);
		hs.validHotelSearch();
		
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result) {
        if (env.equalsIgnoreCase("useBrowserstack") & result.getStatus() == ITestResult.SUCCESS) {
            ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"passed\", \"reason\": \"QC Passed - All validations successful.\"}}");
        } else if (env.equalsIgnoreCase("useBrowserstack") & result.getStatus() == ITestResult.FAILURE) {
            ((JavascriptExecutor) driver).executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"QC Failed - Test failed due to: " + result.getThrowable() + "\"}}");
        }
        if (driver != null) {
            driver.quit();
        }
	}

}

	
