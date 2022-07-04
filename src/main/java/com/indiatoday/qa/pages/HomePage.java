package com.indiatoday.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indiatoday.qa.base.TestBase;
import com.indiatoday.qa.util.CommonUtil;

public class HomePage extends TestBase {
	@FindBy (tagName = "img")
	List<WebElement> TotalLinks;
	@FindBy (xpath = "//div[contains(@class,'-gutters')]/button")
	WebElement Menu_btn;
	@FindBy (xpath = "//span[text()='WebStory']")
	WebElement webStoryBtn;
	
	//Initializing Page Objects 
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		public void clickonHamburgerMenuButton() {
			Menu_btn.click();
		}
		public void clickonWebStoryBtn() {
			webStoryBtn.click();
		}
		public void showAllLinks() {
			System.out.println("All Links are "+ TotalLinks.size());
		}
		public void CheckActivelinkstatuswithvideourl() {
			List<WebElement> activelink=new ArrayList<WebElement>();
			 for(int i=0;i<TotalLinks.size();i++) {
				 
				 if(TotalLinks.get(i).getAttribute("src") !=null && (! TotalLinks.get(i).getAttribute("src").contains("data")) ) {
					 activelink.add(TotalLinks.get(i));
					 
				 }

				 
			 }
			 
			 //System.out.println("Size of actual link " + activelink.size());
			 for (int j=0;j<activelink.size();j++) {
				 //System.out.println(activelink.get(j).getAttribute("src"));
			 }
			 List<WebElement> VideoUrl= TotalLinks;
			 List<WebElement> finallink=new ArrayList<WebElement>();
			 
	             for(int i=0;i<VideoUrl.size();i++) {
				 if(VideoUrl.get(i).getAttribute("videourl")!=null)  {
					 finallink.add(VideoUrl.get(i));

				 }
				
			 
			 } 
	             for (int i=0;i<finallink.size();i++) {
	            	 System.out.println(finallink.get(i).getAttribute("videourl"));
	             }
	             activelink.addAll(finallink);
	             System.out.println("Size of actual link after merging  " + activelink.size());
	             List<String> urllist =new ArrayList<String>(); 
	         		for (WebElement e:activelink) {
	         		String srcurl=	e.getAttribute("src");
	         		      urllist.add(srcurl);
	         		    //checkBrokenLink(srcurl);

	         				}
	         	
	         		for (WebElement e:activelink) {
	             		String videourl=e.getAttribute("videourl");
	             		urllist.add(videourl);
	             				}
	         		long sTime=	System.currentTimeMillis();

	         		urllist.parallelStream().forEach(e -> CommonUtil.checkBrokenLink(e));
	         		long EndTime=	System.currentTimeMillis();
	         		System.out.println("Total time taken"+(EndTime-sTime));
		}
}
