package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CabBooking extends BasePage{

	public CabBooking(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//WebElements for searching SUV page
	
	@FindBy(xpath="//label[normalize-space()='SUV']")
	WebElement suvBtn;
		
	@FindBy(xpath="//div[@id='List']/div[1]//p[contains(text(),'₹')][@class='font28 latoBlack blackText ']")
	WebElement totalFare;
	
	@FindBy(xpath="//*[@id=\"List\"]/div")
	List<WebElement> cars;
	
	public boolean suv=false;
	public void selSuv() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='SUV']"))).click();
			suv=true;
		}
		catch(Exception e) {
			
		}
	}
	 
	public void extractPrice() { 
		
		if(suv) {
			String fare =totalFare.getText();
			System.out.println("Minimum price is "+fare);
		
		}else {
			System.out.println("No cabs Available!...Please try any other date.");
		}
	}
	
	public void repeatTestCase() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='chMmtLogo']"))).click();
	}
	
	
	
}
