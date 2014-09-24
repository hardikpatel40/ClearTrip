package Tests;

import java.io.FileInputStream;








import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;









import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Testutils.Helper;

public class TestBase {
	
	public static WebDriver driver = null;
	public static Properties config = null;
	public static Properties OR = null;
	public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	Helper h;
	@BeforeSuite
	public void Initialize() throws IOException, InterruptedException{
		h = new Helper();
		
		//BasicConfigurator.configure();
		APPLICATION_LOGS.debug("Starting testsuite and loading config files");
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\cleartrip.properties");
		config = new Properties();
		config.load(fp);
		
		APPLICATION_LOGS.debug("loading OR files");
		
		FileInputStream fp1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\OR.properties");
		OR = new Properties();
		OR.load(fp1);
		
		System.out.println("Choosing Browser " + config.getProperty("browserType"));
		if(config.getProperty("browserType").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
	}else if(config.getProperty("browserType").equals("firefox")){
		driver = new FirefoxDriver();
	}

	}
	
	@AfterSuite
	  public void afterSuite() {
		  driver.close();
	  }
	
}
