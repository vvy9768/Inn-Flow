package pages;

import webUtills.WebUtills;

public class Sales {

	WebUtills utill;	
public Sales(WebUtills utill) {
	// TODO Auto-generated constructor stub
	this.utill=utill;
}



public void windowHandle(String title) {
	utill.getWindowHandleByTitle( title);
}
}