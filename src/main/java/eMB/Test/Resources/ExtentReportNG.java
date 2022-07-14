package eMB.Test.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports reports;
	public  static ExtentReports getExtentReport()
	{
		String path="E:\\Twinkil\\Test\\Screenshots\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tested By", "Twinkil Patel");
		return reports;
	}
}
