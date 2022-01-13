package testCases;



import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BasePage.TestBasePage;
import pages.Accounting;
import pages.HomePage;
import pages.LoginPage;
import pages.Report;




public class TestCase_TC01 extends TestBasePage {

LoginPage logIn;	
HomePage hmPage;
@Test//(priority = 1)
public void  TC001ValidateLoginPage() {
	 logIn=new LoginPage(utill);
	 logIn.validateUserName();
	
	 logIn.validateUserPass();
	 
	 logIn.validateUserLogIn();
    utill.getExtentLogger().log(Status.PASS, " Inn-flow is LogIn Successfully ");
}

@Test//(priority = 2)
public void TC0002GenrateReport() throws InterruptedException {	
	logIn=new LoginPage(utill);
	hmPage=logIn.validLogIn();
	 utill.getExtentLogger().log(Status.PASS, " Inn-flow is LogIn Successfully ");

	hmPage.wait_HomePage();
	 utill.getExtentLogger().log(Status.PASS, " HomePage open Successfully ");

	Accounting accPg=hmPage.NavigateOnAccount();
	  utill.getExtentLogger().log(Status.PASS, " AccountPage open Successfully ");

	Thread.sleep(2000);
	accPg.windowHandle("Dashboard");
	accPg.clickOnReport();
	
	String  nameOfDepartment[] =utill.getKey("ReportName");
	Report reprt=accPg.NavigateOnReport(nameOfDepartment[0]);
	accPg.windowHandle("Report");
	String [] date=utill.getKey("Date");
	 reprt.putDateOReport(date[0]);
	 
    String [] HIDs=utill.getKey("EHID");
	for (int i = 0; i <= HIDs.length-1; i++) {
		HIDs=utill.getKey("EHID");
    reprt.chaked_ChakeBoxes( HIDs[i]);
	}
    reprt.loadTheReport();
    
    reprt.focusOnPage("https://inn-flow-staging-reporting.azurewebsites.net/ReportGenerated.");
    reprt.downloadTheReportInExcel();
    utill.getExtentLogger().log(Status.PASS, " Report downloaded  Successfully ");

}



}