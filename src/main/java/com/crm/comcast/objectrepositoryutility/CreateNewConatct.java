package com.crm.comcast.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericlib.WebDriverUtiles;




public class CreateNewConatct extends WebDriverUtiles{
	
  WebDriver driver;
	public CreateNewConatct(WebDriver driver) {  
        this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	  private WebElement organizationLookUpImage;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBys({
				@FindBy(xpath="//a[@title='Contacts']/../../td[4]")
			})
	private List<WebElement> getAllName;
	
	public List<WebElement> getGetAllName() {
		return getAllName;
	}
	@FindBy(linkText="del")
	private WebElement delete;
	
	/**
	 * create a new Conatct with mandatry feild
	 * @param lastName
	 */

	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContact(String lastName, String orgName) {
		lastNameEdt.sendKeys(lastName);
		organizationLookUpImage.click();
		swicthToWindow(driver, "module=Accounts");
		Organizations op = new Organizations(driver);
		op.getSearchEdt().sendKeys(orgName);
		op.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		swicthToWindow(driver, "Contacts");
		saveBtn.click();
	}
	public void deleteContact(String lastName) {
		//createContact(lastName);
	
		Home hp=new Home(driver);
		hp.getContactLnk().click();
		int count=0;
		boolean flag=false;
		for(WebElement wb:getAllName)
		{
			String actual = wb.getText();
			count++;
			if(lastName.equals(actual))
			{

				driver.findElement(By.xpath("//a[text()='"+lastName+"']/../../td[1]")).click();
				delete.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		}
	}
	
	
}
