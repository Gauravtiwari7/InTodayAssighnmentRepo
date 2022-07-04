package com.indiatoday.qa.util;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.indiatoday.qa.base.TestBase;

public class CommonUtil extends TestBase {
	public void mousehover(WebElement element,WebDriver driver) {
		Actions action =new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	 public static  void explicitwaitbyxapth(WebDriver driver,String xpathexpression) {
			@SuppressWarnings("deprecation")
			WebDriverWait wait=new WebDriverWait(driver,60);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathexpression)));
	 }
	 public static void iSleep(double secs)
		{
			try
			{
				Thread.sleep((long) (secs*1000));
			}
			
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	 public static void clickbyjs(WebElement item,WebDriver driver) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
		}
	 public static void scrooldowntoend() {
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	 public static void scrroldownto250() {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,250)");
	 }
	 
	 public static void checkBrokenLink(String LinkUrl) {
			try {
				URL url= new URL(LinkUrl) ;
			HttpURLConnection httpurlConnection=(HttpURLConnection) url.openConnection();
			httpurlConnection.setConnectTimeout(5000);
			httpurlConnection.connect();
			if(httpurlConnection.getResponseCode() >=400) {
				System.out.println(LinkUrl + "--->" + httpurlConnection.getResponseMessage() + "is a broken link ");
				
			}
			else {
				System.out.println(LinkUrl + "--->" + httpurlConnection.getResponseMessage());		}
				
			} catch (Exception e) {
				
			}
	 }
	
}
