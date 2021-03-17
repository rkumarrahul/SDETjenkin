package com.crm.autodesk.leadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.objectrepositoryutility.CreatingNewLeadPage;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.Lead;
import com.crm.comcast.objectrepositoryutility.LeadInformationPage;

public class ConvertLeadBySelectingTC29OpertunityAllChecksTest extends BaseClass{
	/*
	 * Rahul
	 */
	@Test
	public void ConvertLeadToOpertunitiesAllChecks() throws Throwable
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
		lip.getCheckedOppertunity().click();
		lip.getEnterDate().click();
		lip.getSelectTodayDate().click();
		lip.getSaveConvertLeadBTN().click();
		String ActRes = driver.getTitle();
		/*verify the Lead Convert into Organization page */
		boolean flag = ActRes.contains("Organizations");
		Assert.assertTrue(flag);
	
	
	
	
	
	
	
	
	
	}
}
