package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.ExcelUtils;

public class GiftCardPage extends BasePage{
	
	public GiftCardPage(WebDriver driver) {
		super(driver);
	}
//	String path1="C:\\Users\\2318179\\eclipse-workspace\\final_eval\\testData\\mmtDataFile.xlsx";
	ExcelUtils el=new ExcelUtils("C:\\Users\\2318179\\eclipse-workspace\\final_eval\\testData\\mmtDataFile.xlsx");	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/main/main/div[1]/div[2]/ul/li[5]")
	WebElement clickGiftCard;
	
	@FindBy(xpath="//li[@data-cy='SingleGiftCard_468']")
	List<WebElement> giftBtn;
	
	@FindBy(xpath="//span[@data-cy='Counter_443']")
	WebElement cardCount;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/div[4]/div/div[2]/label/span")
	WebElement slider;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/div[3]/ul/li[2]")
	WebElement emailBtn;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/div[4]/div[2]/div/input")
	WebElement recipientDetails;
	
	//sender details
	@FindBy(xpath="//*[@id=\"deliveredSection\"]/div/div/div[1]/div/input")
	WebElement name;
	
	@FindBy(xpath="//*[@class='deliver__via__tab make-flex space-around']/li[2]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"deliveredSection\"]/div/div/div[2]/div[2]/div/input")
	WebElement number;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[2]/div[1]/div[3]/button")
	WebElement buyNow;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/div[4]/div[2]/p")
	WebElement errorMsg;
	
	@FindBy(xpath = "//li[@data-cy='SingleGiftCard_468']")
	List<WebElement> giftCards;
	
	
	
	//action methods
	
	
	
	
	@FindBy(xpath = "//span[@data-cy='Counter_443']")
	WebElement plus;
	
	@FindBy(xpath = "//input[@name='senderName']")
	WebElement senderName;
	
	@FindBy(xpath = "//input[@name='senderMobileNo']")
	WebElement senderPhoneNumber;
	
	@FindBy(xpath = "//input[@name='senderEmailId']" )
	WebElement senderEmailId;
	
	@FindBy(xpath = "//button[normalize-space()='BUY NOW']")
	WebElement buyNow1;
	
	@FindBy(xpath = "//li[@data-cy='SingleGiftCard_468']")
	List<WebElement> giftCardsNew;
	
	
	
	
	public void selectingGiftCard() {
		int randomNumber= randomNumber();
		int i=1;
		for(WebElement ele:giftCardsNew) {
			if(i==randomNumber) {
				js.executeScript("arguments[0].click();", ele);
			}
			i++;
		}
	}	
	
	public void noOfGifts(int n) {
		for(int i=1; i<n;i++) {
			plus.click();
		}
	}
	public void emailGifting() {
		email.click();
	}
	
	public void groupGifting() {
		WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slider round']")));
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void inputPhoneNumber() throws IOException {
		List<WebElement> list= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='append-bottom12']//input")));
		for(WebElement ele:list) {
			String s= randomName();
			ele.sendKeys(s);
		}
	}
	
	
	public void senderInfo() {
		senderName.sendKeys(randomName());
		senderPhoneNumber.sendKeys(randomPhoneNumber());
		senderEmailId.sendKeys(randomeEmail());
	}
	
	public void clickBuyNow() {
		buyNow.click();
	}
	
	public String errorMessage() {
		String errMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form__field__wrap']/p"))).getText();
		return errMsg;
	}
	
	
	
	
}
