package com.crm.autodesk.leadtest;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.objectrepositoryutility.CreatingNewLeadPage;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.Lead;
import com.crm.comcast.objectrepositoryutility.LeadInformationPage;
@Listeners(com.crm.comcast.genericlib.ListenerIMP.class)

public class ConvertLeadBySelectingTC28OpertunityAndOrganizationNotFillTest extends BaseClass {
	/*
	 * Rahul
	 */
	@Test(retryAnalyzer=com.crm.comcast.genericlib.RetryAnalyzer.class)
	public void ConvertLeadToOpertunitiesNOtFillMaindatory() throws Throwable
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
		lip.getUnCheckedContacts().click();
		lip.getCheckedOppertunity().click();
		lip.getSaveConvertLeadBTN().click();
		//handle Alert 
		Alert alert = driver.switchTo().alert();
		String Actudmssg = alert.getText();

		alert.accept();
		/*verify the Alert Mssg in LeadConverting  Page*/
		boolean flag = Actudmssg.equals("Values for Mandatory Fields are missing");
		Assert.assertTrue(flag);
	
	
	}
}
