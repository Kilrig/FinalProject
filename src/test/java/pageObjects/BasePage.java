package pageObjects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;
import utilities.ExcelUtils;

public class BasePage extends BaseClass{
	
	public WebDriver driver;
	public static WebDriverWait wait;	
	public static Actions act;
	public static JavascriptExecutor js;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		act=new Actions(driver);
		js= (JavascriptExecutor)driver;
	}
	
	
	
	
	
	
	
	
	
}
