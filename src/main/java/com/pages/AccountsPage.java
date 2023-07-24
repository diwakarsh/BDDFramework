package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	private By accountSections= By.xpath("//ul[@class='myaccount-link-list']//li//span");

	//Constructor
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public int getCountOfAccountsSection()
	{
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList()
	{
		List<String> accountList= new ArrayList<>();
		List<WebElement> sectionList=driver.findElements(accountSections);
		for(WebElement e:sectionList)
		{
			accountList.add(e.getText());
		}
		return accountList;
	}
	
	public String getAccountPageTitle()
	{
		return driver.getTitle();
	}
}
