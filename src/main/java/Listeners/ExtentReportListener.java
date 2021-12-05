package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tech.grasshopper.reporter.ExtentPDFReporter;

public class ExtentReportListener implements ITestListener {

	private static ExtentReports extent = createInstance();

   	public ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
   	
   	private static ExtentReports extentReports ;

	private static ExtentReports createInstance() {
		
		extentReports=new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/src/test/resources/reports/SampleExtentHTMLReports.html");
		//ExtentPDFReporter pdf = new ExtentPDFReporter(System.getProperty("user.dir") + "/src/test/resources/reports/SampleExtentPDFReports.pdf");
		
		spark.config().setReportName("Sample Extent Report");
		
		extentReports.attachReporter(spark);
		//extentReports.attachReporter(pdf);
		extentReports.setSystemInfo("Author", "Jayanta");
		extentReports.setSystemInfo("Company", "TEST");

		return extentReports;
	}

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");


	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		extent.flush();
		extentTest.remove();

	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTest test =extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		extentTest.set(test);

	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		extentTest.get().pass("Test Passed"+ result.getMethod().getMethodName());
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		extentTest.get().fail("Test Failed"+ result.getMethod().getMethodName());
		//extentTest.get().fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot()).build());


	}

}
