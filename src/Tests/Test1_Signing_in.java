package Tests;


import java.io.IOException;

import org.apache.xerces.impl.dv.util.Base64;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Testutils.Helper;

public class Test1_Signing_in extends TestBase {
	
  @Test
  public void URL_Opening() throws InterruptedException, IOException {
	  h = new Helper();
	  System.out.println("********************************************");
	  System.out.println("            FIRST TEST CASE                 ");
	  System.out.println("********************************************");
	  driver.get(config.getProperty("url"));
	  if(driver.getTitle().equalsIgnoreCase("Problem loading page")){
		  Assert.fail("Server cannot found particular URL");
		  h.takescreenshot("Test1_URL");
	  }else if(driver.getTitle().equals("Cleartrip | Flights, Hotels, Packages, Buses, Trains")){
		  System.out.println("URL found");
	  }
	  
	  driver.get(config.getProperty("url") + "signin" );
	  driver.manage().window().maximize();
	  System.out.println("SIGNING IN WITH USERNAME AND PASSWORD");
	  
	  //Signing in with username and password
	  byte[] decoded = Base64.decode(config.getProperty("password"));
		String value = new String(decoded, "UTF-8");
	  driver.findElement(By.id(OR.getProperty("email_id"))).sendKeys(config.getProperty("email"));
	  driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(value);
	  driver.findElement(By.id(OR.getProperty("signin_button_id"))).click();
	  System.out.println("LOGGED IN SUCCESSFULLY WITH USERNAME AND PASSWORD");
	  APPLICATION_LOGS.debug("LOGGED IN SUCCESSFULLY WITH USERNAME AND PASSWORD");
	  Reporter.log("Test1_Signing_URL success");
	  System.out.println("\n");
	  h.sleep(4);
	  h.takescreenshot("test1");
	  h.sleep(2);  
	  	  
  }

  

}
