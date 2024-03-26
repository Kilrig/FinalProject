	package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PopupPage;
import testBase.BaseClass;

public class TC_04_CountAdult extends BaseClass{
	
	

	
	@Test(priority=1)
	public void adultCount() throws InterruptedException, IOException {
		
		HomePage hp = new HomePage(driver);
		hp.clickHotel();
		
		logger.info("Screenshot taken...");
		hp.listData();
		System.out.println("Test Case 3 has passed.");
		logger.info("Count of Adult stored...");
		
		
	}
}
