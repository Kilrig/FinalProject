package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pageObjects.PopupPage;


public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;

	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) throws IOException, InterruptedException {
		FileReader file=new FileReader(".//src//test//resources//configure.properties");
		 p=new Properties();
		 p.load(file);
		 
		 logger = LogManager.getLogger(this.getClass());
		 
		switch(br.toLowerCase()) {
			case "chrome":{
				driver=new ChromeDriver();
				break;
			 	}
			 case "edge":{
				 driver=new EdgeDriver();
				 break;
			 	}
				 default:{
					 System.out.println("No matching browser selected");
					 return;
				 	}
				 }
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("webUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@AfterClass
	public void complete() {
		System.out.println("_____________________________________________________________________");
		driver.quit();
	}
	
	public static String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	public int randomNumber() {
		int randomNumber = (int)(Math.random()*20)+1;
		return randomNumber;
	}
	
	public String randomPhoneNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	public String randomName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeEmail()
	{
		String s1=RandomStringUtils.randomAlphabetic(5);
		String s2=RandomStringUtils.randomAlphabetic(5);
		return s1+'@'+s2;
	}
	
	@BeforeMethod
	public void handlePopUp() throws InterruptedException {
		
		try {
			PopupPage pg = new PopupPage(driver);
			Thread.sleep(5000);
			pg.switchToFrame();
			Thread.sleep(2000);
			pg.clickCloseButton();
			pg.switchOutOfFrame();
			
			logger.info("Window Switched....");
		}catch(Exception e) {
			//continue 
		}
		
	}
	
}
