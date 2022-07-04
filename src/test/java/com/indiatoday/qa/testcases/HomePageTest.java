package com.indiatoday.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.indiatoday.qa.base.TestBase;
import com.indiatoday.qa.pages.HomePage;
import com.indiatoday.qa.popups.HamburgermenuPopup;
import com.indiatoday.qa.util.CommonUtil;
import com.indiatoday.qa.util.TestUtil;
@Listeners(com.indiatoday.qa.util.ListenerItest.class)

public class HomePageTest extends TestBase {
	HomePage homepage;
	HamburgermenuPopup Hampoup;
	TestUtil testutil;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homepage =new HomePage();
		Hampoup=new HamburgermenuPopup();
		
	}
	@Test
	public void findbrokenlinksonhomepage() throws InterruptedException {
		CommonUtil.iSleep(5);
		CommonUtil.scrooldowntoend();
		CommonUtil.iSleep(10);
//		homepage.showAllLinks();
//		CommonUtil.iSleep(5);

		homepage.CheckActivelinkstatuswithvideourl();
	      
	}
	@Test
	public void changetheme() {
		homepage.clickonHamburgerMenuButton();
		CommonUtil.iSleep(5);

		Hampoup.clickonchangetheme();
	}
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
}
