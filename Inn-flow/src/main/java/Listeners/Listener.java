package Listeners;




import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class Listener implements ITestListener{
	   
	  
	  
	public void onTestStart(ITestResult result) { 
//	       ExtentTest test=extent.createTest(result.getTestClass().getName()+ "::"+result.getMethod().getMethodName());
//	        extentTest.get().log(Status.INFO, "start the test case "+result.getMethod().getMethodName());
		System.out.println(result.getMethod().getMethodName()+" is started the test ");
	}  
	  
	public void onTestSuccess(ITestResult result) {  
//	  String logText= "<b>Test Method "+result.getMethod().getMethodName()+" Successful<b>";
//	 Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//	  extentTest.get().log(Status.PASS, "Test Successful"+m);
//	  
	  
	System.out.println("Success of test cases and its details are : "+result.getMethod().getMethodName());  
	
	}  
	  
	public void onTestFailure(ITestResult result) {  
//	   String exceptionMassage=Arrays.toString(result.getThrowable().getStackTrace());
//		extentTest.get().log(Status.FAIL, "fauled the test case ");
//	
//		WebUtills.getObj().takeSnapshot(WebUtills.getdriver(),result.getMethod().getMethodName());
		
	System.out.println("Failure of test cases and its details are : "+result.getMethod().getMethodName());  
	}  
	  
	public void onTestSkipped(ITestResult result) {  
//		  String logText= "<b>Test Method "+result.getMethod().getMethodName()+" Skipped<b>";
//			 Markup m= MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
//			  extentTest.get().log(Status.SKIP, "your test case is skipped "+result.getMethod().getMethodName());
//			  
		
	System.out.println("Skip of test cases and its details are : "+result.getMethod().getMethodName());  
	}  
	  
	  
	public void testCaseStarted(ITestContext context) {  
	// TODO Auto-generated method stub  
		System.out.println("Test case  is Started");
	}  
	  
	public void onFinish(ITestContext context) {  
	//	extentTest.get().log(Status.PASS, "browser is closed and testcase is finished "+context.getName());
//        if(extent!=null)
//        	extent.flush();
		System.out.println( "Test case is Finished");
	} 
	
}