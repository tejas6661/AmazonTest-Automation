package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentManager {

	
		// TODO Auto-generated method stub
		
		
//		    private static ExtentReports extent;
//
//		    public static ExtentReports getInstance() {
//
//		        if (extent == null) {
//		            ExtentSparkReporter spark =
//		                new ExtentSparkReporter(
//		                    "test-output/ExtentReport.html");
//
//		            extent = new ExtentReports();
//		            extent.attachReporter(spark);
//
//		            extent.setSystemInfo("Project", "Selenium Automation");
//		            extent.setSystemInfo("Tester", "QA Team");
//		            extent.setSystemInfo("Environment", "QA");
//		        }
//
//		        return extent;
//		    }
	
	 private static ExtentReports extent;

	
	 public static ExtentReports getInstance() {

	     if (extent == null) {

	         String reportPath = System.getProperty(
	                 "extent.report.path",
	                 "test-output/ExtentReport.html"
	         );

	         System.out.println("ExtentReport path: " + reportPath);

	         File reportFile = new File(reportPath);

	         File parent = reportFile.getParentFile();

	         if (parent != null && !parent.exists()) {
	             parent.mkdirs();
	         }

	         System.out.println("Report directory: " +
	                 reportFile.getAbsolutePath());

	         ExtentSparkReporter spark =
	                 new ExtentSparkReporter(reportPath);

	         extent = new ExtentReports();
	         extent.attachReporter(spark);

	         extent.setSystemInfo("Project", "Selenium Automation");
	         extent.setSystemInfo("Tester", "QA Team");
	         extent.setSystemInfo("Environment", "QA");

	         System.out.println("ExtentReports initialized.");
	     }

	     return extent;
	 }
	 
}
