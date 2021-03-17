package com.crm.comcast.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * @author Rahul
 */
public class LeadInformationPage {
	public LeadInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Convert Lead")
	private WebElement navigateOnConvertLead;
	public WebElement getNavigateOnConvertLead() {
		return navigateOnConvertLead;
	}
	@FindBy(id="select_account")
	private WebElement unCheckOrganization;
	public WebElement getUnCheckOrganization() {
		return unCheckOrganization;
	}
	@FindBy(id="select_contact")
	private WebElement unCheckedContacts;
	public WebElement getUnCheckedContacts() {
		return unCheckedContacts;
	}
	@FindBy(id="select_potential")
	private WebElement checkedOppertunity;
	public WebElement getCheckedOppertunity() {
		return checkedOppertunity;
	}
	@FindBy(id="jscal_trigger_closedate")
	private WebElement enterDate;
	public WebElement getEnterDate() {
		return enterDate;
	}
	@FindBy(xpath="//td[contains(@class,'today')]")
	private WebElement selectTodayDate;
	public WebElement getSelectTodayDate() {
		return selectTodayDate;
	}
	@FindBy(name="Save")
	private WebElement saveConvertLeadBTN;
	public WebElement getSaveConvertLeadBTN() {
		return saveConvertLeadBTN;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement captureHeaderafterConvLead;
	public WebElement getCaptureHeaderafterConvLead() {
		return captureHeaderafterConvLead;
	}
	@FindBy(xpath="//a[@class='hdrL"
			+ "ink']")
	private WebElement capturePageName;
	public WebElement getCapturePageName() {
		return capturePageName;
	}
	
}
