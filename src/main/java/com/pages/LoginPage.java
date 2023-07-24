package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//Locators
	private By emailid =By.id("email");
	private By password=By.id("passwd");
	private By signInButton=By.id("SubmitLogin");
	private By forgotPwdLink=By.linkText("Forgot your password1?"); //To fail the test

	
	//Constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinlExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String userName)
	{
		driver.findElement(emailid).sendKeys(userName);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String usrName,String pwd)
	{
		System.out.println("Loging with "+usrName);
		driver.findElement(emailid).sendKeys(usrName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
}
