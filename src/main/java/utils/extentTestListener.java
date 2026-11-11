package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class extentTestListener implements ITestListener{
	
//	    private static ExtentReports extent =
//	        extentManager.getInstance();
//
//	    private static ThreadLocal<ExtentTest> test =
//	        new ThreadLocal<>();
//
//	    @Override
//	    public void onTestStart(ITestResult result) {
//	        ExtentTest extentTest =
//	            extent.createTest(result.getMethod().getMethodName());
//
//	        test.set(extentTest);
//	    }
//
//	    @Override
//	    public void onTestSuccess(ITestResult result) {
//	        test.get().log(Status.PASS, "Test passed");
//	    }
//
//	    @Override
//	    public void onTestFailure(ITestResult result) {
//	        test.get().log(Status.FAIL, "Test failed");
//	        test.get().fail(result.getThrowable());
//	    }
//
//	    @Override
//	    public void onTestSkipped(ITestResult result) {
//	        test.get().log(Status.SKIP, "Test skipped");
//	    }
//
//	    @Override
//	    public void onFinish(ITestContext context) {
//	        extent.flush();
//	    
//	}

	private static ExtentReports extent =
            extentManager.getInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
    	   System.out.println("Extent Listener: Test Started");

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
        test.get().log(Status.INFO, "Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(Status.PASS, "Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(Status.FAIL, "Test failed");

        if (result.getThrowable() != null) {
            test.get().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        if (test.get() == null) {
            test.set(extent.createTest(
                    result.getMethod().getMethodName()));
        }

        test.get().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
    	System.out.println("Extent Listener: Flushing report");
        extent.flush();
    }
	
}
