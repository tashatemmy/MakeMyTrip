package makemytriptests;

import org.testng.annotations.Test;

import makemytrippages.Login;

public class LoginTest extends Base {
	@Test(groups = {"login", "smoke", "regression", "positive"}, priority = 1)
	public void validLoginTest() {
		Login login = new Login(driver);
		login.validCreateAccount();
		
	}
	
	@Test(groups = {"login", "regression", "negative"}, priority = 2)
	public void invalidPasswordTest() throws InterruptedException {
		Login login = new Login(driver);
		login.invalidpasswordLogin();
		
	}
	
	@Test(groups = {"login", "regression", "negative"}, priority = 3)
 	public void invalidMobileTest() throws InterruptedException {
		Login login = new Login(driver);
		login.invalidmobileLogin();
		
	}

}
