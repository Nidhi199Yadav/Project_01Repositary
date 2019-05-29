package TestCases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Interfaces.FooterInterface;
import PageObjects.RegisterPage;

public class LoginTestCase extends RegisterPage {
@BeforeSuite
public void setup()
{
	launchBrowser("chrome","\\main\\resource\\Browser\\chromedriver.exe");
}
@Test 
public void app()
{
	launchApp("https://www.facebook.com/");
}
@Test
public void login()
{
	chkLoginWithValid();
}
@Test 
public void checkLinksClick()
{
	checkLinks();
}
}