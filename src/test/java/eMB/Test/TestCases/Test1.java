package eMB.Test.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eMB.Test.PageObject.Dashboard;
import eMB.Test.Resources.TestBase;
import io.reactivex.rxjava3.functions.Action;

public class Test1 extends TestBase{
	
	
	WebDriver driver;
	Dashboard db;


	@BeforeTest
	public void initialize() throws IOException {
	driver = initializer();
		
	}
	
	@Test()
	public void Firstmethod() throws InterruptedException, IOException {
		//String dosFromMonth, String dosFromYear, String dosToMonth,String dosToYear
		driver.get(prop.getProperty("ServerUrl"));
		Thread.sleep(1000);
		db = new Dashboard(driver);
		db.getuserLoginLink().click();
		db.getuserid().sendKeys(prop.getProperty("test"));
		db.getpassword().sendKeys(prop.getProperty("FirstAccPassword"));
		db.getLoginbutton().click();
		Thread.sleep(1000);
			
	}	
	@Test()
	public void Secondmethod() throws InterruptedException, IOException {
		System.out.println("This is test2");
			
	}
	@Test()
	public void Thirdmethod() throws InterruptedException, IOException {
	System.out.println("This is test3");
			
	}
}