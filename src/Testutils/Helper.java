package Testutils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import Tests.TestBase;


public class Helper extends TestBase{
	
/*	public void drivers(){
		if(config.getProperty("browserType").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
			driver = new ChromeDriver();
	}else if(config.getProperty("browserType").equals("firefox")){
		driver = new FirefoxDriver();
	}
}*/
	
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
	
	
	public void login(String email,String password) throws UnsupportedEncodingException, InterruptedException {
		System.out.println(String.format("Signing it with %s/%s from header login" ,email,password));
		
	
		return;
	}	
}

