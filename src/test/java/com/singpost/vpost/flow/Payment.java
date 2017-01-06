package com.singpost.vpost.flow;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.singpost.vpost.common.utils.GeneralActions;
import com.singpost.vpost.common.utils.ReusableActions;
import com.singpost.vpost.pagecomponents.Insurancepage;
import com.singpost.vpost.pagecomponents.MyShopping;
import com.singpost.vpost.pagecomponents.Paymentpage;
import com.singpost.vpost.pagecomponents.Signin;



public class Payment extends GeneralActions {
	static WebDriver driver;
	MyShopping MyShopping;
	Signin Signin;
	Insurancepage Insurancepage;
	Paymentpage Paymentpage;
	//Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	

	 @BeforeClass
	  public void setUp() throws IOException {
		  
		  driver = launchBrowser(driver, "firefox");
		  MyShopping = PageFactory.initElements(driver, MyShopping.class);
		  Signin = PageFactory.initElements(driver, Signin.class);
		  Insurancepage= PageFactory.initElements(driver, Insurancepage.class);
		  Paymentpage= PageFactory.initElements(driver, Paymentpage.class);
	      ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      
	 }


	/**
	 * Login Checkout Flow Test Script
     */
	
	 @Test( priority = 1, dataProviderClass=Signin.class, dataProvider="getData")
		public void checkoutAsRegisteredLoginUserFlow(String username,String password) throws Exception {
			try {
			 System.out.println("123"+MyShopping);
			 Signin.clickSignIn();
		     // System.out.println("Click siginin");
		      Thread.sleep(5000);
		      Signin.enterUserName(username);
		      Signin.enterPassword(password);
		      Signin.clickLoginButton();
		      MyShopping.Shoppingclick();
		     // MyShopping.packagesclick();
		      MyShopping.clickProceedButton();
		      Thread.sleep(5000);
		      Insurancepage.ClickAddvcare();
		      Thread.sleep(4000);
		      Paymentpage.clickradiobtn();
		      Paymentpage.clickpaybtn();
		     
		     
			}
			catch(Exception e){
				e.printStackTrace();
			}
		 }	
	
/*	 @Test( priority = 2, dataProviderClass=Paymentpage.class, dataProvider="getData")
		public void Paymentflow(String cardname,String cardnumber,String month,String year,String ccvno) throws Exception {
		 
			try {  	
			 System.out.println("Payment");
		      Paymentpage.clickradiobtn();
		      Paymentpage.Cardname(cardname);
		      Paymentpage.Cardnumber(cardnumber);
		      Paymentpage.entermonth(month);
		      Paymentpage.enteryear(year);
		      Paymentpage.vercode(ccvno);
		      Paymentpage.clickpaybtn();
		         
		}
		catch(Exception e){
			e.printStackTrace();
		}
	 }	*/
	
	@AfterClass
	public static void quitDriver()  {
	 try{
		
		 Thread.sleep(5000);
	 driver.quit();
		 }
		  catch (Exception e) {
		 e.printStackTrace();
		 }
	
}

	 
}
