package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.GiftCardPage;
import pageObjects.HomePage;
import pageObjects.PopupPage;
import testBase.BaseClass;

public class TC_03_GiftCardBoookingTest extends BaseClass{
	

	
	@Test(priority=1)
	public void gift() {
		HomePage hp = new HomePage(driver);
		hp.ckickGift();
		hp.switchWindow();
		logger.info("Window Switchedy...");
	}
	
	@Test(priority=2)
	public void giftCard() throws IOException {
		GiftCardPage gp = new GiftCardPage(driver);
		gp.selectingGiftCard();
		gp.emailGifting();
		gp.noOfGifts(3);
		gp.groupGifting();
		gp.inputPhoneNumber();
		gp.senderInfo();
		gp.clickBuyNow();
		String msg = gp.errorMessage();
		System.out.println(msg);
		System.out.println("Test Case 2 has passed.");
		logger.info("TestCase 3 Passed...");
	}
}
