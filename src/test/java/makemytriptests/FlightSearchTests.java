package makemytriptests;

import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import makemytrippages.FlightSearch;
import makemytrippages.Login;

public class FlightSearchTests extends Base {
	
	@BeforeMethod
	public void loginAccount() {
		Login login = new Login(driver);
		login.validCreateAccount();
		
	}
	
//	public void tearDown() {
//		driver.close();
//	}
	
	@Test(groups = {"flightsearch", "smoke", "regression", "positive"}, priority = 1)
	public void validOneWayTest_FS01() throws InterruptedException {
		FlightSearch fs = new FlightSearch(driver);
		fs.validOneWayFlightSearch();
	}
	
	@Test(groups = {"flightsearch", "regression", "positive"}, priority = 2)
	public void validRoundTripTest_FS05() throws InterruptedException {
		FlightSearch fs = new FlightSearch(driver);
		fs.validRoundTripFlightSearch();
	}
	
	@Test(groups = {"flightsearch", "regression", "negative"}, priority = 3)
	public void invalidCityInputTest_FS07() throws InterruptedException {
		FlightSearch fs = new FlightSearch(driver);
		fs.invalidCityInput("Baltimore, Maryland");
	}
	
	@Test(groups = {"flightsearch", "regression", "positive"}, priority = 4)
	public void validMultiTest_FS10() throws InterruptedException {
		FlightSearch fs = new FlightSearch(driver);
		fs.validMultiCityFlightSearch( "heathrow Airport, UK", "Los Angeles, US");
	}
	

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {
		String[] groups = result.getMethod().getGroups();
	    for (String group : groups) {
	        if (group.equals("positive")) {
		FlightSearch fs = new FlightSearch(driver);
		fs.flightsearchTeardown(driver);
	        }else if (group.equals("negative") & driver != null ){
	        	driver.close();
	        }
	}
	}

}
