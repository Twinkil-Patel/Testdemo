package eMB.Test.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Dashboard 
{
	public WebDriver driver;

	By userLoginLink = By.xpath("//h3[normalize-space()='User']");
	By userid = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By Loginbutton = By.xpath("//button[normalize-space()='Login']");
    By dashboardlable = By.xpath("//div[@class='panel-heading']");
    By dashlet = By.xpath("//span[normalize-space()='Billing Delay Summary']");
    
    public Dashboard(WebDriver driver) 
    {
		this.driver = driver;
    }
    public WebElement getuserLoginLink() {
		return driver.findElement(userLoginLink);
	}

	public WebElement getuserid() {
		return driver.findElement(userid);
	}

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginbutton() {
		return driver.findElement(Loginbutton);
	}   
    public WebElement getdashboardlable()
    {
    	return driver.findElement(dashboardlable);
    }
    public WebElement getdashlet()
    {
    	return driver.findElement(dashlet);
    }
}
