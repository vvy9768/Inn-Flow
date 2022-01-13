package BasePage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;
import com.aventstack.extentreports.Status;
import Listeners.SendJavaMailReport;
import excelUtill.ExcelUtill;
import webUtills.WebUtills;

public class TestBasePage {
	
protected WebUtills utill=WebUtills.getObj();
protected static final Logger logger = Logger.getLogger(TestBasePage.class.getClass());  
protected Map<String ,String > mapdata;

 

@BeforeSuite
public void beforeSuit() {
	
	utill.initHtmlReport();

}
 
 
 
	@BeforeMethod ()
	public void beforeMethod(Method name) {
		String methodName=name.getName();
		utill.setExtentLogger(methodName);
		
	  	utill.launchBrowser(utill.getPropVal("browser"));
		utill.maximize();
		utill.get(utill.getPropVal("url"));
		
		utill.setTestCaseData( ExcelUtill.getExcelObj().getDataFromExcel("src/main/resources/WorkBooks/Credencials.xlsx", "Sheet1", methodName, "TestCaseID"));
		utill.setTestCaseData( ExcelUtill.getExcelObj().getDataFromExcel("src/main/resources/WorkBooks/EHID.xlsx", "Sheet1", "TC001", "Report"));
		
 }


	@AfterMethod
	public void afterMethod(ITestResult result) {
		logger.info("Test Suite Execution method has been Start");
		  
		if (result.getStatus() == ITestResult.FAILURE) {
			utill.getExtentLogger().log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent
																								// report
			utill.getExtentLogger().log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add
																									// error/exception
																									// in extent

			String screenshotPath = utill.takeSnapshot(utill.getdriver(),result.getName()); // to add screen shot in extent reports
			try {
				utill.getExtentLogger().addScreenCaptureFromPath(screenshotPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (result.getStatus() == ITestResult.SKIP) {
			utill.getExtentLogger().log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			utill.getExtentLogger().log(Status.PASS, "Test Case PASSED IS " + result.getName());
		
		}
		
		utill.quitBrowser();
		logger.info("Test Suite Execution method has been completed");
		utill.flushExtentsReport();
	}


@AfterSuite
public void afterSuit() {
	
	 new SendJavaMailReport(utill.getReportName()).main();
	 
}

}