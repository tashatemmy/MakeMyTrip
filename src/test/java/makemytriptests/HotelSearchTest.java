package makemytriptests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import makemytrippages.HotelSearch;

public class HotelSearchTest extends Base {
	
	@Test
	public void validHotelSearchTest() {
		HotelSearch hs = new HotelSearch(driver);
		hs.validHotelSearch();
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		if (driver != null) {
            driver.quit();
        }
	}

}

	
