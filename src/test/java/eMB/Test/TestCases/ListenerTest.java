package eMB.Test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import eMB.Test.Resources.ExtentReportNG;
import eMB.Test.Resources.TestBase;



public class ListenerTest extends TestBase implements ITestListener{
	ExtentReports extent = ExtentReportNG.getExtentReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	}
// to capture failed Test cases screenshot
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String testMethod = result.getMethod().getMethodName();
		try {
			extentTest.get().addScreenCaptureFromPath(getScrenshot(testMethod,driver), result.getMethod().getMethodName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

	@Override
	public int hashCode() {
		return 0;
		// TODO Auto-generated method stub
		//return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return false;
		// TODO Auto-generated method stub
		//return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return null;
		// TODO Auto-generated method stub
		//return super.clone();
	}

	@Override
	public String toString() {
		return null;
		// TODO Auto-generated method stub
		//return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//super.finalize();
	}
	

}
