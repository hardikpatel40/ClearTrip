package Tests;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Testutils.Helper;

public class Test4_Flights_Currency extends TestBase{

  @Test
  public void Currency() throws InterruptedException {
	  h = new Helper();
	  System.out.println("********************************************");
	  System.out.println("            FOURTH TEST CASE                ");
	  System.out.println("********************************************");
	  driver.get(config.getProperty("url") + "/flights");
	  System.out.println(driver.getCurrentUrl());
	  
	  //Clicking the currency container
	  driver.findElement(By.cssSelector(OR.getProperty("currency_button"))).click();
	  //Getting all the elements from currency container
	  List<WebElement> currency_cont = driver.findElement(By.cssSelector(OR.getProperty("currency_ele"))).findElements(By.tagName(OR.getProperty("tag")));
	  if(currency_cont.size()==0){
		  Assert.fail("Currency container element is incorrect");
	  }
	  
	  
	  //Clicking any randomly currency
	 Actions a = new Actions(driver);
	 Random currency_rand = new Random();
	 int rand_cur = currency_rand.nextInt(currency_cont.size());
	  a.moveToElement(currency_cont.get(rand_cur)).click();
	  a.perform();
	  String abc = driver.findElement(By.cssSelector(OR.getProperty("currency_select"))).getText();
	  System.out.println("Randomly Currency selected is = " +abc);
	  APPLICATION_LOGS.debug("Randomly Currency selected is = " +abc);
	 
	 
	 //******************FILLING Flight DETAILS*********************************
	 driver.findElement(By.id(OR.getProperty("from"))).sendKeys("Hyderabad");
	 driver.findElement(By.id(OR.getProperty("to"))).sendKeys("Mumbai");
	
	 driver.findElement(By.id(OR.getProperty("depart_click"))).click();
	 List<WebElement> months = driver.findElement(By.cssSelector(OR.getProperty("month"))).findElements(By.tagName(OR.getProperty("month_tag")));
	 if(months.size()==0){
		 Assert.fail("months container element is incorrect");
	 }
	 Random rand = new Random();
	 int var = rand.nextInt(months.size());
	 months.get(var).click();
	 driver.findElement(By.id(OR.getProperty("search_button"))).click();
	 h.sleep(5);
	 
	 //Picking out flight result currency
	 List<WebElement> verify_rs = driver.findElement(By.cssSelector(OR.getProperty("verify_currency_cont"))).findElements(By.tagName(OR.getProperty("verify_currency_tag")));
	 String final_rs = verify_rs.get(0).getText();
	 String str[] = final_rs.split("[0-9]");
	 System.out.println("Searched flight result currency is in " +str[0]);
	 APPLICATION_LOGS.debug("Searched flight result currency is in " +str[0]);

	 if(abc.contains(str[0])){
		 System.out.println("CURRENCY AMOUNT IS MATCHED");
		 APPLICATION_LOGS.debug("CURRENCY AMOUNT IS MATCHED");

	 }else{
		 System.out.println("CURRENCY AMOUNT NOT MATCHED");
		 APPLICATION_LOGS.debug("CURRENCY AMOUNT NOT MATCHED");

	 }
	 System.out.println("\n");
	 Reporter.log("Test4_Flights_Currency success");
	}
	  
  }

