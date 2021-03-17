package com.crm.autodesk.leadtest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericlib.BaseClass;
import com.crm.comcast.objectrepositoryutility.CreatingNewLeadPage;
import com.crm.comcast.objectrepositoryutility.Home;
import com.crm.comcast.objectrepositoryutility.Lead;
import com.crm.comcast.objectrepositoryutility.LeadInformationPage;

@Listeners(com.crm.comcast.genericlib.ListenerIMP.class)
public class ConvertLeadBySelectingOnlyContactTC25ChekboxsTest extends BaseClass {
	/*
	 * Rahul
	 */
	@Test(groups={"System"})
	public void ConvertLeadToContacts()  throws Throwable
	{
		
		 /*read test script data */ 
		String leadName = elib.getExcelData("Lead", 5, 3)+jLib.generateRandomNum();
		String companyName=elib.getExcelData("Lead", 5, 2)+jLib.generateRandomNum();
		System.out.println(leadName);
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
		//convert lead
		LeadInformationPage lip=new LeadInformationPage(driver);
		lip.getNavigateOnConvertLead().click();
		lip.getUnCheckOrganization().click();
		lip.getSaveConvertLeadBTN().click();
		/*verify the contact in contact info Page*/
		WebElement capturePageName = lip.getCapturePageName();
		String actlres = capturePageName.getText();
		boolean flag = actlres.contains("Contacts");
		Assert.assertTrue(flag);
		
		
	}
}
