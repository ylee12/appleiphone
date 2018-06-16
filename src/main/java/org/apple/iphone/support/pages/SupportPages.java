package org.apple.iphone.support.pages;

import org.apple.iphone.support.util.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
public class SupportPages {
	WebDriver driver;
	public SupportPages(WebDriver driver){
		this.driver =driver;
	}
	public String getFeedBackMsg()
	{
		driver.findElement(By.xpath(".//*[@id='ac-globalnav']/div/ul[2]/li[9]/a")).click();
		driver.findElement(By.id("ac-gn-searchform-input")).sendKeys("iphone battery");
		driver.findElement(By.id("ac-gn-searchform-input")).sendKeys(Keys.ENTER);		 
		WebElement filterButtonWE = TestBaseClass.waitForVisibleElement(By.id("filter-view-button"),30);
		filterButtonWE.click();
		driver.findElement(By.xpath(".//*[@id='searchFilter-doctype']/li[1]/a")).click();
		WebElement searchResultWE = TestBaseClass.waitForVisibleElement(By.className("SearchResult-heading"),30); 
		String expected = searchResultWE.getText();
		Assert.assertTrue(expected.contains("iPhone Battery and Performance"));
		System.out.println("Expected value::" + expected);
		driver.findElement(By.className("SearchResult-heading")).click();
		WebElement titleWE =TestBaseClass.waitForVisibleElement(By.id("howto-title"),30); 
		String pageLoadedText = titleWE.getText();
		Assert.assertTrue(pageLoadedText.contains("iPhone Battery and Performance"),"Text Message Not Matching");
		System.out.println("Page Loaded Text Value::" + expected);
		new Actions(driver).moveToElement(driver.findElement(By.id("yes-button"))).perform();
		driver.findElement(By.id("yes-button")).click();
		expected = driver.findElement(By.xpath(".//*[@id='rating-done']")).getText();
		System.out.println("Rating Message:::"+ expected);
		return expected;
	}
}
