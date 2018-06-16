package org.apple.iphone.support.util;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
public class TestBaseClass {
	protected static  WebDriver driver;
	//protected variables are access via subclass..
	@Parameters({"browserType","url"})
	@BeforeTest
	public void invokeBrowser(String browserType,String url)
	{
		if(browserType.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/ylee/selenium-web-browser-dvr-mac/geckodriver"); 
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("CH"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/ylee/selenium-web-browser-dvr-mac/chromedriver"); 
			driver = new ChromeDriver();
		}
		else if(browserType.equals("SF"))
		{
			 //SafariDriver now requires manual installation of the extension prior to automation
			driver = new SafariDriver();
		}
		else
		{
			//zoom should be 100%
			//Enable protected mode should be selected for all the four zones..
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	public  void openBrowser(String url)
	{
		
		driver.get(url);
		 
	}
	public static WebElement waitForVisibleElement(By locator,long timeInSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return e;
	}

}
