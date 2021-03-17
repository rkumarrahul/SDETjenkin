package com.crm.autodesk.leadtest;

import org.openqa.selenium.Alert;
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
public class LeadBatchExecution extends BaseClass {
	/*
	 * Rahul
	 */

	@Test(priority=1)
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
	
		
		@Test(priority=2,retryAnalyzer=com.crm.comcast.genericlib.RetryAnalyzer.class)
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
			
		@Test(priority=3,retryAnalyzer=com.crm.comcast.genericlib.RetryAnalyzer.class)
		public void ConvertLeadToOrganization() throws Throwable
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
				//convert lead By selecting Organization and Contact
				LeadInformationPage lip=new LeadInformationPage(driver);
				lip.getNavigateOnConvertLead().click();
				lip.getSaveConvertLeadBTN().click();
				String actlres = driver.getTitle();
				/*verify the Lead Covert in Organization page or not*/
				boolean flag = actlres.contains("Organizations");
				Assert.assertTrue(flag);
			}
	
				@Test(priority=4,retryAnalyzer=com.crm.comcast.genericlib.RetryAnalyzer.class)
				public void ConvertLeadToOpertunitiesByNOtFill() throws Throwable
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
					lip.getCheckedOppertunity().click();
					lip.getSaveConvertLeadBTN().click();
					//handle Alert mssg
					Alert alert = driver.switchTo().alert();
					String Actudmssg = alert.getText();
					
					alert.accept();
					///*verify the Alert Mssg in LeadConverting */
					boolean flag = Actudmssg.equals("Values for Mandatory Fields are missing");
					Assert.assertTrue(flag);
				}	
					
					@Test(priority=5,retryAnalyzer=com.crm.comcast.genericlib.RetryAnalyzer.class)
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
				@Test(priority=6,retryAnalyzer=com.crm.comcast.genericlib.RetryAnalyzer.class)
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
