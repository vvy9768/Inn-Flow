package pages;

import java.util.Map;

import org.openqa.selenium.By;

import basePage.BasePage;
import excelUtill.ExcelUtill;
import webUtills.WebUtills;

public class LoginPage extends BasePage {

	WebUtills utill;

	public LoginPage(WebUtills utill) {
		this.utill = utill;

	}

	By uName = By.cssSelector("input#formBasicEmail");

	By uPass = By.cssSelector("input#formBasicPassword");

	By uLogIn_Bt = By.cssSelector("button[type='submit']");

	private Map<String, String> tcData;

	public void validateUserName() {
		tcData = utill.getTestCaseDataMap();
		utill.verifyElement_IsVisible(uName, "UserName Input box ");
		utill.sendKeys(uName, tcData.get("uName"));
	}

	public void validateUserPass() {

		
		utill.verifyElement_IsVisible(uPass, "UserPass  Input box ");
		utill.sendKeys(uPass, tcData.get("uPass"));
	}

	public void validateUserLogIn() {

		utill.getElement(uLogIn_Bt);
		utill.verifyElement_IsVisible(uLogIn_Bt, "User logIn Button ");
		utill.click(uLogIn_Bt);
	}

	public HomePage validLogIn() {
		tcData = utill.getTestCaseDataMap();
		utill.getElement(uName);
		utill.sendKeys(uName, tcData.get("uName"));
		utill.getElement(uPass);
		utill.sendKeys(uPass, tcData.get("uPass"));
		utill.getElement(uLogIn_Bt);
		utill.click(uLogIn_Bt);
		return new HomePage(utill);
	}

}