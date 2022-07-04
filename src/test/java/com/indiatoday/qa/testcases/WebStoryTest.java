package com.indiatoday.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.indiatoday.qa.base.TestBase;
import com.indiatoday.qa.pages.HomePage;
import com.indiatoday.qa.pages.WebStory;
import com.indiatoday.qa.popups.HamburgermenuPopup;
import com.indiatoday.qa.popups.WebStoryPopup;
@Listeners(com.indiatoday.qa.util.ListenerItest.class)

public class WebStoryTest extends TestBase {
	HomePage homepage;
	WebStory webstory;
	WebStoryPopup webstorypopup;
	
	public WebStoryTest() {
		super();

	}
	@BeforeMethod
	public void setUp(){
		initialization();
		homepage =new HomePage();
		webstory=new WebStory();
		webstorypopup=new WebStoryPopup(); 
	}
	@Test
	public void clickonwebstories(){
		homepage.clickonWebStoryBtn();
		webstory.findallwebstories();
		
	}
	@Test
	public void clickonwebstoryandcapturestorytext(){
		homepage.clickonWebStoryBtn();
		webstory.clickonwebstory();
		//webstorypopup.capturewebstorytext();
	}
	

}
