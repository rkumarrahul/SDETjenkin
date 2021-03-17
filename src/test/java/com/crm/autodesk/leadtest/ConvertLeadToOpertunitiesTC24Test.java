package com.crm.autodesk.leadtest;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.objectrepositoryutility.CreatingNewLeadPage;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.Lead;
import com.crm.comcast.objectrepositoryutility.LeadInformationPage;


public class ConvertLeadToOpertunitiesTC24Test extends BaseClass {
	/*
	 * Rahul
	 */
	@Test(retryAnalyzer=com.crm.comcast.genericlib.RetryAnalyzer.class)
	public void ConvertLeadToOpertunities() throws Throwable
	{
		
		 /*read test script data */ 
		String leadName = elib.getExcelData("Lead", 5, 3)+jLib.generateRandomNum();
		String companyName=elib.getExcelData("Lead", 5, 2)+jLib.generateRandomNum();
		
		/*step 2 : navigate to to Lead*/ 
		Home home=new Home(driver);
		home.getLeadsLnk().click();
		
		/*step 3 : navigate to create New Lead Page*/
		new Lead(driver).getClickOnCreateLead().click();
		
		/*step 4 : create a Lead*/ 
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.getEnterLastNameTB().sendKeys(leadName);
		cnlp.getEnterCompanyNameTB().sendKeys(companyName);
		cnlp.getClickOnSaveBTN().click();
		//converting lead
		LeadInformationPage lip=new LeadInformationPage(driver);
		lip.getNavigateOnConvertLead().click();
		lip.getUnCheckOrganization().click();
		lip.getUnCheckedContacts().click();
		lip.getCheckedOppertunity().click();
		lip.getEnterDate().click();
		lip.getSelectTodayDate().click();
		lip.getSaveConvertLeadBTN().click();
		//handle alert
		Alert alert = driver.switchTo().alert();
		String actmsg = alert.getText();
		alert.accept();
		/*verify the Alert Mssg in LeadConverting  Page*/
		boolean flag = actmsg.equals("Select either Organization or Contact to convert the lead");
		Assert.assertTrue(flag);
		
		
	}
}
