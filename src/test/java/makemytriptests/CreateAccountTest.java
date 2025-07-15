package makemytriptests;

import org.testng.annotations.Test;

import makemytrippages.CreateAccount;

public class CreateAccountTest extends Base {
	
	
	@Test(groups = {"login", "smoke", "regression", "positive"}, priority = 1)
	public void validAccount() {
		CreateAccount ca = new CreateAccount(driver);
		ca.validCreateAccount();
	}

}
