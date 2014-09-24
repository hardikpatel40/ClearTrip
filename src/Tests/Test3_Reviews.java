package Tests;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Testutils.Helper;

public class Test3_Reviews extends TestBase{

  @Test
  public void Hotel_Reviews() throws InterruptedException, IOException {
	  h = new Helper();
	  System.out.println("********************************************");
	  System.out.println("           THIRD TEST CASE                  ");
	  System.out.println("********************************************");
	  driver.get(config.getProperty("url"));
	  driver.manage().window().maximize();
	  h.sleep(2);
	  //Getting all elements like flights,hotels,buses in container
	  List<WebElement> cont = driver.findElement(By.cssSelector(OR.getProperty("hotels_cont_css"))).findElements(By.tagName("li"));
	  if(cont.size()==0){
		  Assert.fail("Container element is missing");
	  }else{
	
	  //Clicking flights button
	  cont.get(1).findElement(By.tagName(OR.getProperty("hotels_click_tagname"))).click();
	  h.sleep(2);
	  
	  //Searching destination point
	 driver.findElement(By.id(OR.getProperty("search_dest"))).sendKeys("Goa,Goa India");
	 driver.findElement(By.id(OR.getProperty("search_dest"))).sendKeys(Keys.ENTER);
	
	 //Randomly getting checkin date from container
	 driver.findElement(By.id(OR.getProperty("checkindate_id"))).click();
	 h.sleep(3);
	 List<WebElement> from_date = driver.findElement(By.cssSelector(OR.getProperty("date_css"))).findElements(By.tagName(OR.getProperty("date_css_tagname")));
	 if(from_date.size()==0){
		 Assert.fail("from_date container element is incorrect");
	 }
	 Random a = new Random();
	 int date = a.nextInt(from_date.size());
	 h.sleep(1);
	 from_date.get(date).click();
	 h.sleep(3);
	 
	 //Randomly getting checkout date from container
	 driver.findElement(By.id(OR.getProperty("checkoutdate_id"))).click();
	 List<WebElement> to_date = driver.findElement(By.cssSelector(OR.getProperty("date1_css"))).findElements(By.tagName(OR.getProperty("date1_tagname")));
	 if(to_date.size()==0){
		 Assert.fail("to_date container element is incorrect");
	 }
	 Random a1 = new Random();
	 int date1 = a1.nextInt(to_date.size());
	 h.sleep(1);
	 to_date.get(date1).click();
	 h.sleep(2);
	 
	 //Clicking search hotels button
	 driver.findElement(By.id(OR.getProperty("search_hotel_button"))).click();
	 h.sleep(10);
	 
	 //********************************************************************
	 System.out.println("Collecting list of all hotels:::");
	 h.takescreenshot("test3_hotel_reviews");
	 List<WebElement> hotels_list = driver.findElement(By.xpath(OR.getProperty("hotel_cont"))).findElements(By.cssSelector(OR.getProperty("hotels_list")));
	 
	 if(hotels_list.size()==0){
		 Assert.fail("Container hotels_list element is incorrect");
	 }else{
	 System.out.println("Total number of hotels found is = " +hotels_list.size());
	 APPLICATION_LOGS.debug("Total number of hotels found is = " +hotels_list.size());
	 for(int i=0;i<hotels_list.size()-1;i++){
		 System.out.println(hotels_list.get(i).findElement(By.cssSelector(OR.getProperty("hotel_name"))).getText());
		
		 if(hotels_list.get(i).findElement(By.cssSelector(OR.getProperty("review_name"))).getText().contains("reviews")){
			 System.out.println(hotels_list.get(i).findElement(By.cssSelector(OR.getProperty("review_name"))).getText());
			 System.out.println("-------------------------------------------------");
		 }else{
			 System.out.println("REVIEW NOT PRESENT");
			 System.out.println("-------------------------------------------------");
		 }
	 }
	  } 
	 System.out.println("\n");
	 Reporter.log("Test3_Hotel_Reviews success");
  }
}
}