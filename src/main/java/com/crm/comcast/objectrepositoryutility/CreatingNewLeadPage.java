package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	public CreatingNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement enterLastNameTB;
	
	public WebElement getEnterLastNameTB() {
		return enterLastNameTB;
	}

	public WebElement getEnterCompanyNameTB() {
		return enterCompanyNameTB;
	}
	@FindBy(name="company")
	private WebElement enterCompanyNameTB;
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement clickOnSaveBTN;

	public WebElement getClickOnSaveBTN() {
		return clickOnSaveBTN;
	}
	
}
