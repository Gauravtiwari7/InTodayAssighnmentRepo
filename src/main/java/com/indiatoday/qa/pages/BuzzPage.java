package com.indiatoday.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indiatoday.qa.base.TestBase;
import com.indiatoday.qa.util.CommonUtil;

public class BuzzPage extends TestBase {
	@FindBy (xpath = "//span[text()='Buzz']")
	WebElement Buzz_btn;
	@FindBy (tagName = "img")
	List<WebElement> TotalLinks;
  public BuzzPage() {
		PageFactory.initElements(driver, this);

  }
  public void clikonbuzz() {
	  Buzz_btn.click();
  }
  public void scroolpage3andverifybrokenlinks() {
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,3200)");
		 CommonUtil.iSleep(10);
		 jse.executeScript("window.scrollBy(0,4000)");
		 CommonUtil.iSleep(10);

		
		 System.out.println("Size of all link " + TotalLinks.size());
		 
		 List<WebElement> activelink=new ArrayList<WebElement>();
		 for(int i=0;i<TotalLinks.size();i++) {
			 
			 if(TotalLinks.get(i).getAttribute("src") !=null && (! TotalLinks.get(i).getAttribute("src").contains("data")) ) {
				 activelink.add(TotalLinks.get(i));
				 
			 }
			 
			 
		 }
		 
		 System.out.println("Size of actual link " + activelink.size());
		 List<String> urllist =new ArrayList<String>(); 
  		for (WebElement e:activelink) {
  		String srcurl=	e.getAttribute("src");
  		      urllist.add(srcurl);
  		    //checkBrokenLink(srcurl);

  				}
  	
  		
  		long sTime=	System.currentTimeMillis();

  		urllist.parallelStream().forEach(e -> CommonUtil.checkBrokenLink(e));
  		long EndTime=	System.currentTimeMillis();
  		System.out.println("Total time taken"+(EndTime-sTime));


	  
  }
}
