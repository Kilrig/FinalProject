package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;


public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	List<WebElement> adults;
	String path = "C:\\Users\\2318179\\eclipse-workspace\\final_eval\\testData\\Sheet1.xlsx";
	ExcelUtils util = new ExcelUtils(path);
	
	//WebElements for main page
	
	@FindBy(xpath="//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")
	WebElement popupAlert;
	
	@FindBy(xpath="//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[7]/span")
	WebElement cabBtn;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[1]/ul/li[1]")
	WebElement oneWayRdobtn;
	
	@FindBy(xpath="//input[@id='fromCity']") 
	WebElement fromBtn;
	
	@FindBy(xpath="//input[@id='toCity']")
	WebElement toBtn;
	
	@FindBy(xpath="//*[@id=\"departure\"]")
	WebElement departure;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div[1]/div[5]/label")
	WebElement travellerCount;
	
	@FindBy(linkText = "SEARCH")
	WebElement srchBtn;
	
	@FindBy(xpath="//*[@placeholder='From']")
	WebElement fromInput;
	
	@FindBy(xpath="//*[@placeholder='To']")
	WebElement toInput;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[1]")
	WebElement dateArrow;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")
	WebElement month;
	
	@FindBy(xpath="//*[@class='applyBtn']")
	WebElement selectDate;
	
	@FindBy(xpath = "//iframe[@id='webklipper-publisher-widget-container-notification-frame']")
	WebElement frame;
	
	@FindBy(xpath = "//a[@id='webklipper-publisher-widget-container-notification-close-div']")
	WebElement closeButton;
	


	
	@FindBy(xpath="//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/span/a/span[1]/span")
	WebElement hotelBtn;
	
	@FindBy(xpath="//*[@id=\"guest\"]")
	WebElement noOfAdult;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div/div[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div")
	WebElement arrowAdultCount;
	
	@FindBy(xpath="//li[@data-cy='tertiaryRowItem_Gift Cards']")
	WebElement giftCard;
	
	
	//action methods
	
	

	//action methods
	
	public void switchToFrame() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']")));
		driver.switchTo().frame(frame);
	}
	public void clickCloseButton() {
		js.executeScript("arguments[0].click();", closeButton);
	}
	public void switchOutOfFrame() {
		driver.switchTo().defaultContent();
	}
	
	
	public void cabBook() {
		cabBtn.click();
	}
	
	public void validateRdoBtn() {
		boolean oneWay  = oneWayRdobtn.isSelected();
		if(oneWay==false) {
			oneWayRdobtn.click();
		}else {
			//do nothing
		}
	}
	
	public void addDetails(String fromCity , String toCity) throws InterruptedException {
		fromBtn.click();
		fromInput.sendKeys(fromCity);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+fromCity+"']"))).click();
//		toBtn.click();
		toInput.sendKeys(toCity);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+toCity+"']"))).click();
//		departure.click(); 
		
		
	}
	
	public void datePicker() {

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='Next Month']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Months']/div[2]//div[text()='1']"))).click();

	}
	 
	public void timeSelector() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-cy='HrSlots_81']/span[contains(text(),'06')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-cy='MinSlots_83']/span[contains(text(),'30')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-cy='MeridianSlots_82']/span[contains(text(),'AM')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='APPLY']"))).click();

	}
	
	
	public void clickSearch() throws InterruptedException {
		srchBtn.click();
	}
	
	public void clickHotel() {
		hotelBtn.click();
	}
	
	
	
	public List<WebElement> hotel() {
		
		WebElement w1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hsw_inputBox roomGuests']")));
		act.moveToElement(w1).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='adult_count']"))).click();
		List<WebElement> adults=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='gstSlct__list']/li"))); 
		return adults;
		
		
	}
	public void listData() throws IOException {
		List<WebElement> listt = hotel();
		System.out.println("The List of Adults available has been stored in the Excel Sheet.");
		for(int i = 0 ; i<listt.size();i++) {
			String count=listt.get(i).getText();
			util.setCellData("Sheet1",0,0,"Adult Count");
			util.setCellData("Sheet1",i+1,0,count);

		}
	}
	
	public void ckickGift() {
		giftCard.click();
	}
	
	public void switchWindow() {
		String wh= driver.getWindowHandle();
		Set<String> list= driver.getWindowHandles();
		for(String s:list) {
			if(s!=wh) {
				driver.switchTo().window(s);
			}
		}
	}
	
	
	
	
}
