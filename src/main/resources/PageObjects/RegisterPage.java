package PageObjects;

import Utility.commonFun;

public class RegisterPage extends commonFun {

	public void chkLoginWithValid()
	{
		sendData("id", "email","abc@gmail.com");
		sendData("id", "pass","password");
		clickEl("xpath", "//input[@type='submit']");
	}
}
