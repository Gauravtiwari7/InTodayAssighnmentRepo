package com.indiatoday.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.indiatoday.qa.base.TestBase;
import com.indiatoday.qa.pages.BuzzPage;
import com.indiatoday.qa.pages.HomePage;
import com.indiatoday.qa.util.CommonUtil;
import com.indiatoday.qa.util.TestUtil;
@Listeners(com.indiatoday.qa.util.ListenerItest.class)
public class BuzzPageTest extends TestBase {
	BuzzPage buzzpage;
	TestUtil testutil;
	
	public BuzzPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		buzzpage=new BuzzPage();
	}
	@Test
	public void findbrokenlinksonhomepage() throws InterruptedException {
		CommonUtil.iSleep(5);
		buzzpage.clikonbuzz();
		CommonUtil.iSleep(5);
       buzzpage.scroolpage3andverifybrokenlinks();

		
	      
	}
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	

}
