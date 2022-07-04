package com.indiatoday.qa.popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indiatoday.qa.base.TestBase;

public class HamburgermenuPopup extends TestBase {
	@FindBy (xpath = "//p[text()='Theme']")
	WebElement themeswitchBtn;
	
	public  HamburgermenuPopup() {
		PageFactory.initElements(driver, this);
	}
	public void clickonchangetheme() {
		themeswitchBtn.click();
	}
}
