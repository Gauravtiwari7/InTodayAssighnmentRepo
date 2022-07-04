package com.indiatoday.qa.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.indiatoday.qa.base.TestBase;
import com.indiatoday.qa.util.CommonUtil;

public class WebStoryPopup extends TestBase {
	@FindBy (xpath = "//p[@class='lqjwe pa lqjwe-a']//parent::div//h1")
	WebElement Story1popupscreen;
	@FindBy (xpath = "//p[@class='muzxw pa']//parent::div//h2")
	WebElement Story2popupscreen;
	@FindBy (xpath = "//p[@class='cfeqw pa']//parent::div//h2")
	WebElement Story3popupscreen;
	@FindBy (xpath = "//p[@class='urdmf pa']//parent::div//h2")
	WebElement Story4popupscreen;
	@FindBy (xpath = "//p[@class='stsfm pa']//parent::div//h2")
	WebElement Story5popupscreen;
	@FindBy (xpath = "//p[@class='koeqa pa']//parent::div//h2")
	WebElement Story6popupscreen;
	@FindBy (xpath = "//p[@class='ujnez pa']//parent::div//h2")
	WebElement Story7popupscreen;
	@FindBy (xpath = "//p[@class='ftuxu pa']//parent::div//h2")
	WebElement Story8popupscreen;
	@FindBy (xpath = "//button[@aria-label='Next page']")
	WebElement nextbtn;
	@FindBy (xpath = "//button[@aria-label='Close']")
	WebElement closetbtn;
	
	public WebStoryPopup() {
		PageFactory.initElements(driver, this);

	}
    public void capturewebstorytext() {
    	
    	CommonUtil.iSleep(5);
    	System.out.println(Story1popupscreen.getText());
    	nextbtn.click();
    	System.out.println(Story2popupscreen.getText());
    	nextbtn.click();
    	System.out.println(Story3popupscreen.getText());
    	nextbtn.click();
    	System.out.println(Story4popupscreen.getText());
    	nextbtn.click();
    	System.out.println(Story5popupscreen.getText());
    	nextbtn.click();
    	System.out.println(Story6popupscreen.getText());
    	closetbtn.click();
    	System.out.println(Story7popupscreen.getText());
    	closetbtn.click();
    	System.out.println(Story8popupscreen.getText());
    	closetbtn.click();
    }
}
