package Testutils;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Tests.TestBase;


public class Helper extends TestBase{
	
	public void drivers(){
		if(config.getProperty("browserType").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
	}else if(config.getProperty("browserType").equals("firefox")){
		driver = new FirefoxDriver();
	}
}
	
	public void sleep(int seconds){
		try{
			Thread.sleep(seconds*1000);
		}catch(Exception e){
			
		}
	}
	
	
	public boolean waitforelement(int timeout,By by){
		while(timeout>0)
		{
			sleep(1);
		List<WebElement> list = driver.findElements(by);
		if(list.size()!=0){
			return true;
						  }
		timeout--;
		}
		System.out.println("Waited for 60 seconds,element not found");
		return false;
		
	}
	
	public void takescreenshot(String filename) throws IOException{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(config.getProperty("screenShotsPath") +"//" +filename+".jpg"));
	}
	
		
}

