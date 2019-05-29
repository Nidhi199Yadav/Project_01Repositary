

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class commonFun 
{
	 static WebDriver driver;
	 By locator;
	public WebDriver launchBrowser(String browser,String path)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			String driverPath  = System.getProperty("user.dir")+
			"\\src"+path;
			System.out.println(driverPath);
			System.setProperty("webdriver.chrome.driver",driverPath);
			 driver  = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			String driverPath1 = System.getProperty("user.dir")+
			"\\src"+path;
			System.out.println(driverPath1);
			System.setProperty("webdriver.gecko.driver",driverPath1);
			driver  = new FirefoxDriver();
		}
		//driver.get(url);
		return driver;
	}
	public void launchApp(String url)
	{
		driver.get(url);
	}
	public By getLocator(String locName,String locValue)
	{
		switch(locName)
		{
		case "id":
			locator=By.id(locValue);
			break;
		case "name":
			locator=By.name(locValue);
			break;
		case "xpath":
			locator=By.xpath(locValue);
			break;
		case "tagName":
			locator=By.tagName(locValue);
			break;
		case "className":
			locator=By.className(locValue);
			break;
		case "cssSelector":
			locator=By.cssSelector(locValue);
			break;
		case "linkText":
			locator=By.linkText(locValue);
			break;
		case "partialLinkText":
			locator=By.partialLinkText(locValue);
			break;
		default:
			System.out.println("not valid");
		}
		return locator;
	}
	public void sendData(String locName,String locValue,String data)
	{
		driver.findElement(getLocator(locName,locValue)).sendKeys(data);
	}
	public void clickEl(String locName,String locValue)
	{
		 driver.findElement(getLocator(locName,locValue)).click();

	}
	public void isElementPresent(String locName,String locValue)
	{
		boolean res=driver.findElement(getLocator(locName, locValue)).isDisplayed();
		System.out.println(res);
	}
	public int getCount(String locName,String locValue)
	{
		//int ttlElms = driver.findElements(getLocator(locName,locValue)).size();

		int countElm=driver.findElements(getLocator(locName, locValue)).size();
		return countElm;
	}
	public String getlinkText(String locName,String locValue,int index)
	{
		String text=driver.findElement(getLocator(locName, locValue)).getText();
		return text;
		
	}
/*	public static void main(String...args)
	{
		commonFun obj=new commonFun();
		//obj.launchBrowser("firefox","\\BrowserDrivers\\chromedriver.exe");
		//obj.launchApp("https://www.facebook.com/");
		obj.sendData("id", "email","abc@gmail.com");
		obj.sendData("id", "pass","password");
		obj.clickEl("xpath", "//input[@type='submit']");
		driver.navigate().back();
		
	}*/
}
