package Tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Testutils.Helper;

public class Test5_Verify_Collection_links extends TestBase{

  @Test
  public void Collections() throws InterruptedException {
	  h = new Helper();
	  System.out.println("********************************************");
	  System.out.println("            FIFTH TEST CASE                 ");
	  System.out.println("********************************************");
	  driver.get(config.getProperty("url"));
	  //Clicking collections
	  List<WebElement> coll_ele = driver.findElement(By.cssSelector(OR.getProperty("collection_link"))).findElements(By.tagName(OR.getProperty("collection_link_tag")));
	  if(coll_ele.size()==0){
		  Assert.fail("collection link is incorrect");
	  }
	  coll_ele.get(1).findElement(By.tagName("a")).click();
	  h.sleep(4);
	  
	  //Getting all main links in container page
	  List<WebElement> coll_links = driver.findElement(By.id(OR.getProperty("collection_link_container"))).findElements(By.tagName(OR.getProperty("collection_tag")));
	  if(coll_links.size()==0){
		  Assert.fail("Main Collection container element is incorrect");
	  }
	  System.out.println("Total main links is = " +coll_links.size());
	  APPLICATION_LOGS.debug("Total main links is = " +coll_links.size());
	  
	//Getting all links href's into hashset
	  HashSet<String> all_links = new HashSet<String>();
	  
	  //Clicking all links under collections 
	  for(int i=0;i<coll_links.size();i++){
		  coll_links.get(i).findElement(By.tagName(OR.getProperty("collection_ele"))).click();
		  System.out.println("Clicking " +(i+1) +": " +coll_links.get(i).findElement(By.tagName(OR.getProperty("collection_ele"))).getText());
		  System.out.println("Collecting all href's under :" +coll_links.get(i).findElement(By.tagName(OR.getProperty("collection_ele"))).getText());
		  System.out.println("\n");
		  h.sleep(2);
		  List<WebElement> links_cont = driver.findElement(By.id(OR.getProperty("collections_links_href"))).findElements(By.tagName(OR.getProperty("href_tag")));
		  for(int j=0;j<links_cont.size();j++){
			  String class_link = links_cont.get(j).getAttribute("class");
			  if(class_link.contains("visibleProjectThumb")){
				  String url_append = links_cont.get(j).findElement(By.tagName("a")).getAttribute("href");
				  all_links.add(url_append);
			  }
		  }
		  h.sleep(2);		  
	  }
		System.out.println("\n");

	
	  //Converting hashset to list
	  	List<String> all = new ArrayList<String>(all_links);
		System.out.println("Total number of links is= " +all.size());
		APPLICATION_LOGS.debug("Total number of links is= " +all.size());
		System.out.println("Taking first 10 href's");
		
		//Clicking all the hrefs
		for(int k=0;k<all.size()-66;k++){
			System.out.println("Clicking " +(k+1) +":" +all.get(k));
		  driver.get(all.get(k));
		  h.sleep(2);
		}
		System.out.println("\n");
		Reporter.log("Test4_Collection_links success");
		
		System.out.println("**********************COMPLETED SUCCESSFULLY****************************");
  }
}