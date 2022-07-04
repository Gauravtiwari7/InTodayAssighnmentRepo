package com.indiatoday.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indiatoday.qa.base.TestBase;
import com.indiatoday.qa.util.CommonUtil;

public class WebStory extends TestBase{
	@FindBy (xpath = "//div[contains(@class,'smallStory card')]//h2")
	List<WebElement> stories;
	@FindBy(xpath = "//iframe[@src='https://thesportstak.com/webstory/']")
	WebElement iframe;
	public WebStory() {
		PageFactory.initElements(driver, this);
	}
	public void findallwebstories() {
		CommonUtil.scrooldowntoend();
		CommonUtil.iSleep(10);
        driver.switchTo().frame(iframe);
		for(int i=0;i<stories.size();i++) {
		System.out.println(stories.get(i).getText());	
		}
		System.out.println("Total size is "+stories.size());
	}
    public void clickonwebstory() {
        driver.switchTo().frame(iframe);
    	stories.get(0).click();
    	
    }
}
