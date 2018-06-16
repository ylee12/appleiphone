package org.apple.iphone.support.tests;
 import org.apple.iphone.support.pages.SupportPages;
import org.apple.iphone.support.util.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class AppleSupportTests extends TestBaseClass {
	@Parameters({"expectedMessage","feedbackMsg"})
	@Test
	public void feedBackFlowTest(String expectedMessage,String feedbackMsg)
	{

		try{
			SupportPages sPage = new SupportPages(driver);
			String expected = sPage.getFeedBackMsg();
			Assert.assertEquals(expected,feedbackMsg,"FeedBack Message Not Matching!!!");
		}
		catch(Exception e)
		{
			System.out.println("FeedBack MEssage Not Captured"+ e.getMessage());
		}


	}


}
