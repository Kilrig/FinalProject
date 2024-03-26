package testCase;

import java.io.IOException; 

import org.testng.annotations.Test;

import pageObjects.CabBooking;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataForTest;

public class TC_01_verifyHomePage extends BaseClass{

	
	@Test(priority=1 , dataProvider = "DataForTest" , dataProviderClass=DataForTest.class)
	public void verifyCabs(String fromCity, String toCity) throws InterruptedException, IOException{
		HomePage hp = new HomePage(driver);
		hp.cabBook();
		hp.validateRdoBtn(); 
		hp.addDetails(fromCity ,toCity);
		hp.datePicker();
		hp.timeSelector(); 
		hp.clickSearch(); 
		
		logger.info("Cab Page Opened....");
		
		
		CabBooking cb = new CabBooking(driver);
		cb.selSuv(); 
		cb.extractPrice();
		
		logger.info("Least Cab Price Extracted....");
		
		System.out.println("Test Case 1 has passed.");
		cb.repeatTestCase(); 
		
	}
	
}
