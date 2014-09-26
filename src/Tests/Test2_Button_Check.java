package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Testutils.Helper;

public class Test2_Button_Check extends TestBase{

  @Test
  public void left_right_button() throws InterruptedException {
	  h = new Helper();
	  System.out.println("********************************************");
	  System.out.println("            SECOND TEST CASE                ");
	  System.out.println("********************************************");
	  driver.get(config.getProperty("url"));
	  h.sleep(2);
	  List<WebElement> ll = driver.findElement(By.cssSelector(OR.getProperty("deals_container_css"))).findElements(By.tagName(OR.getProperty("deals_container_tag")));
	  int l=0;
	  if(ll.size()==0){
		  System.out.println("Deals container is incorrect");
	  }else{
		  
		  //Getting index of current deal image
		  
		  for(int i=0;i<ll.size();i++){
			  if(ll.get(i).getAttribute("class").equals("active")){
				  l = i;
			  }
		}
	  
	  //************************RIGHT ARROW BUTTON CHECK****************************************
	  
	//Clicking right button of deals and retreiving index
	  int m=0;
	  for(int j=0;j<ll.size();j++){
		  driver.findElement(By.cssSelector(OR.getProperty("right_button_css"))).click();
		  h.sleep(2);
	  }
	  for(int i=0;i<ll.size();i++){
		  if(ll.get(i).getAttribute("class").equals("active")){
			  m = i;
		  }
	  }
	  //Comparing indexes with before click and after click
	  if(m==l){
	  System.out.println("RIGHT BUTTON IS WORKING PROPERLY");
	  APPLICATION_LOGS.debug("RIGHT BUTTON IS WORKING PROPERLY");
	  }else{
		  Assert.fail("RIGHT BUTTON ERROR");
	  }
	  
	}
	  //***************************LEFT ARROW BUTTON CHECK***************************************
	
	  //Clicking left button of deals and retreiving index
	  int k=0;
	  for(int j=0;j<ll.size();j++){
		  driver.findElement(By.cssSelector(OR.getProperty("left_button_css"))).click();
		  h.sleep(2);
	  }
	  	 for(int i=0;i<ll.size();i++){
		  if(ll.get(i).getAttribute("class").equals("active")){
			  k =i;
		  }
	  }
	 
	  //Comparing indexes with before click and after click
	  if(l==k){
	  System.out.println("LEFT BUTTON IS WORKING PROPERLY");
	  APPLICATION_LOGS.debug("LEFT BUTTON IS WORKING PROPERLY");
	  }else{
		  Assert.fail("LEFT BUTTON ERROR");
	  }
	  System.out.println("--------TEST CASE 2 COMPLETED-----------");
	  System.out.println("\n");
	  Reporter.log("Test2_Button_Check Success");	 
  }
   
}
